package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityLoginBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    private static final int SIGN_IN = 100;
    private final ArrayList<UserInfoModel> userInfoModel = new ArrayList<>();
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    private ActivityLoginBinding binding;
    private String isActivityName;
    private GoogleSignInClient signInClient;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        init();
    }

    private void init() {
        binding.setOnLoginClick(this);
        getLoadingStatus();
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        signInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }

    private void getLoadingStatus() {
        userViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
            @Override
            public void onChanged(@Nullable ViewModelStatus viewModelStatus) {
                if (viewModelStatus.isLoadingList) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    public void showLoading() {
        loading = ProgressDialog.show(this, getString(R.string.loading), "", true, false);
    }

    public void hideLoading() {
        loading.cancel();
    }


    public void onLoginClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnLogin: {
                if (isActivityName.equalsIgnoreCase("dealer")) {

                    uiHelper.openActivity(this, DealerMainActivity.class);

                } else {

                    if (internet.isNetworkAvailable(this)) {
                        if (validation()) {
                            userViewModel.getLogin(binding.edtEmail.getText().toString()
                                    , binding.edtPassword.getText().toString());
                            getData();
                        }
                    } else {
                        uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                    }
                }
                break;
            }
            case R.id.btnFacebook: {
                uiHelper.showLongToastInCenter(this, "In Progress");
                break;
            }
            case R.id.btnGoogle: {
                Intent intent = signInClient.getSignInIntent();
                startActivityForResult(intent, SIGN_IN);
                break;
            }
            case R.id.txtForgotPassword: {
                uiHelper.openActivity(this, ForgotPasswordActivity.class);
                break;
            }
        }
    }

    public void getData() {
        userViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 && response.getResp().getMessage().equalsIgnoreCase("success")) {
                    if (response.getResp().getDataObject().getUserInfo() != null) {
                        PreferenceHelper.getInstance().setString(ConstUtils.APIAccessToken, response.getResp().getDataObject().getToken());
                        PreferenceHelper.getInstance().setString(ConstUtils.USER_NAME, response.getResp().getDataObject().getUserInfo().getName());
                        uiHelper.openActivity(LoginActivity.this, MainActivity.class);
                        PreferenceHelper.getInstance().setString(ConstUtils.isLogin, ConstUtils.yes);
                        finish();
                    } else {
                        uiHelper.showLongToastInCenter(LoginActivity.this, response.getResp().getMessage());
                        finish();
                    }
                } else {
                    uiHelper.showLongToastInCenter(LoginActivity.this, response.getResp().getMessage());
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            if (account != null) {
                uiHelper.openActivity(this, MainActivity.class);
            }

        } catch (ApiException e) {
            Log.d("GoogleIssue", e.getLocalizedMessage());
        }
    }

    private boolean validation() {
        boolean check = true;
        binding.txtEmail.setError(null);
        binding.txtPassword.setError(null);

        if (binding.edtEmail.getText().toString().isEmpty()) {
            binding.txtEmail.setError(getString(R.string.empty_email));
            check = false;
        } else if (binding.edtPassword.getText().toString().isEmpty()) {
            binding.txtPassword.setError(getString(R.string.field_empty));
            check = false;
        }
        return check;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userViewModel.clear();
    }
}