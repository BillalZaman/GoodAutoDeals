package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityChangePasswordBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class ChangePasswordActivity extends AppCompatActivity {
    private ActivityChangePasswordBinding binding;
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        getLoadingStatus();
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnChangePassword: {
                if (validation()) {
                    if (internet.isNetworkAvailable(this)){
                        userViewModel.getChangePassword(binding.edtOldPassword.getText().toString(),
                                binding.edtNewPassword.getText().toString());
                        getData();

                    } else {
                        uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                    }
                    Toast.makeText(this, "Your Password has been changed. Please logged in again to continue", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }

    private void getData() {
        userViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 200 &&
                        response.getResp().getMessage().equalsIgnoreCase("success")) {


                } else {
                    uiHelper.showLongToastInCenter(ChangePasswordActivity.this, response.getResp().getMessage());
                    finish();
                }
            }
        });
    }

    private boolean validation() {
        boolean check = true;
        binding.txtOldPassword.setError(null);
        binding.txtNewPassword.setError(null);
        binding.txtConfirmPassword.setError(null);

        if (binding.edtOldPassword.getText().toString().isEmpty()) {
            binding.txtOldPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if (binding.edtNewPassword.getText().toString().isEmpty()) {
            binding.txtNewPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if ((binding.edtConfirmPassword.getText().toString().isEmpty())) {
            binding.txtConfirmPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if ((binding.edtNewPassword.getText().toString().length() < 6)) {
            binding.txtNewPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if ((binding.edtConfirmPassword.getText().toString().length() < 6)) {
            binding.txtConfirmPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if (!binding.edtNewPassword.getText().toString().equals((binding.edtConfirmPassword.getText().toString()))) {
            binding.edtConfirmPassword.setError(getString(R.string.password_mismatch));
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