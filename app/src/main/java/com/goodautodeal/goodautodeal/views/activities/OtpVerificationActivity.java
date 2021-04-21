package com.goodautodeal.goodautodeal.views.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityOtpVerficationBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class OtpVerificationActivity extends AppCompatActivity {
    private ActivityOtpVerficationBinding binding;
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp_verfication);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        String isA = getIntent().getStringExtra(ConstUtils.USER_INFO);
        uiHelper.showLongToastInCenter(this, isA);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        moveAuto();
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

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnVerifyotp:{
                if (internet.isNetworkAvailable(this)){
                    userViewModel.getOtpVerification(binding.edtOne.getText().toString() + binding.edtTwo.getText().toString()
                            + binding.edtThree.getText().toString() + binding.edtFour.getText().toString());
                    getData();

                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
            case R.id.txtResendOtp:{
                if (internet.isNetworkAvailable(this)){

                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
        }
    }

    private void moveAuto() {
        binding.edtOne.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtOne.getText().toString().length() == 1) {
                    binding.edtTwo.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });
        binding.edtTwo.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtTwo.getText().toString().length() == 1) {
                    binding.edtThree.requestFocus();
                }
                if (binding.edtTwo.getText().toString().length() == 0) {
                    binding.edtOne.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });
        binding.edtThree.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtThree.getText().toString().length() == 1) {
                    binding.edtFour.requestFocus();
                }
                if (binding.edtThree.getText().toString().length() == 0) {
                    binding.edtTwo.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });
        binding.edtFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (binding.edtFour.getText().toString().length() == 0) {
                    binding.edtThree.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void getData() {
        userViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {
                    uiHelper.showLongToastInCenter(OtpVerificationActivity.this, response.getResp().getMessage());
                    uiHelper.openAndClearActivity(OtpVerificationActivity.this, MainActivity.class);

                } else {
                    uiHelper.showLongToastInCenter(OtpVerificationActivity.this, response.getResp().getMessage());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userViewModel.clear();
    }
}