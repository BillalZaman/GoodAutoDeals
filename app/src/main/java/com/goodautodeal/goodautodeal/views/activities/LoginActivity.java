package com.goodautodeal.goodautodeal.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityLoginBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    private static final int SIGN_IN = 100;
    @Inject
    UIHelper uiHelper;
    private ActivityLoginBinding binding;
    private String isActivityName;
    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnLoginClick(this);
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        signInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }

    public void onLoginClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnLogin: {
                if (isActivityName.equalsIgnoreCase("user")) {
                    uiHelper.openActivity(this, ProfileActivity.class);
                } else {
                    uiHelper.openActivity(this, DealerMainActivity.class);
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
            if (account!=null){
                uiHelper.openActivity(this, MainActivity.class);
            }

        } catch (ApiException e){
            Log.d("GoogleIssue",e.getLocalizedMessage());
        }
    }
}