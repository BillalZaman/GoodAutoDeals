package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityRegistrationBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class RegistrationActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    private UserViewModel userViewModel;
    private UserInfoModel userInfoModel;
    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        init();
    }

    private void init() {
        getLoadingStatus();
        binding.setOnRegisterClick(this);
        userInfoModel = new UserInfoModel();
        binding.setOnRegisterModel(userInfoModel);
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

    public void onRegisterClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnRegister: {
                if (internet.isNetworkAvailable(this)) {
                    if (validation()) {
                        userViewModel.getRegister(binding.getOnRegisterModel());
                        getData();
                    }
                }
            }
        }
    }

    public void getData() {
        userViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 && response.getResp().getMessage().equalsIgnoreCase("success")) {
                    if (response.getResp().getDataObject().equals("")) {
                        uiHelper.openActivity(RegistrationActivity.this, LoginActivity.class);
                        finish();
                    }
                } else {
                    uiHelper.showLongToastInCenter(RegistrationActivity.this, response.getResp().getMessage());
                    finish();
                }
            }
        });
    }

    private boolean validation() {
        boolean check = true;
        binding.txtName.setError(null);
        binding.txtEmail.setError(null);
        binding.txtPhoneNumber.setError(null);
        binding.txtCity.setError(null);
        binding.txtPostCode.setError(null);
        binding.txtAddress.setError(null);
        binding.txtPassword.setError(null);
        binding.txtConfirmPassword.setError(null);

        if (binding.edtName.getText().toString().isEmpty()) {
            binding.txtName.setError("Name Field Cannot Be Empty");
            check = false;

        } else if (binding.edtEmail.getText().toString().isEmpty()) {
            binding.txtEmail.setError(getString(R.string.hint_email));
            check = false;

        } else if (binding.edtNumber.getText().toString().isEmpty()) {
            binding.txtPhoneNumber.setError(getString(R.string.enter_your_phone_number));
            check = false;

        } else if (binding.edtCity.getText().toString().isEmpty()) {
            binding.txtCity.setError(getString(R.string.hint_city));
            check = false;

        } else if (binding.edtPostCode.getText().toString().isEmpty()) {
            binding.txtPostCode.setError(getString(R.string.hint_post_code));
            check = false;

        } else if (binding.edtAddress.getText().toString().isEmpty()) {
            binding.txtAddress.setError(getString(R.string.hint_address));
            check = false;

        } else if (binding.edtPassword.getText().toString().isEmpty()) {
            binding.txtPassword.setError(getString(R.string.hint_city));
            check = false;

        } else if (binding.edtConfirmPassword.getText().toString().isEmpty()) {
            binding.txtConfirmPassword.setError(getString(R.string.hint_city));
            check = false;

        } else if (binding.edtPassword.getText().toString().length() < 6) {
            binding.txtPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if (binding.edtConfirmPassword.getText().toString().length() < 6) {
            binding.txtConfirmPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if (!binding.edtPassword.getText().toString().equals(binding.edtConfirmPassword.getText().toString())) {
            binding.txtConfirmPassword.setError(getString(R.string.password_mismatch));
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