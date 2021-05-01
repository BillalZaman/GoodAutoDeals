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
import com.goodautodeal.goodautodeal.databinding.ActivityProfileBinding;
import com.goodautodeal.goodautodeal.fragments.ProfileFragment;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity {
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private ActivityProfileBinding binding;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        getLoadingStatus();
//        unFocusFields();

        if (internet.isNetworkAvailable(this)) {
            userViewModel.getUserProfile();
            getData();
        } else {
            uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
        }
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

    private void getData() {
        userViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response responsee) {
                if (responsee.getResp().getCode() == 1 &&
                        responsee.getResp().getSuccess().equalsIgnoreCase("success")) {
                    if (responsee.getResp().getDataObject().getUserInfo() != null) {
                        binding.setOnProfileModel(responsee.getResp().getDataObject().getUserInfo());
                    }
                } else {
                    uiHelper.showLongToastInCenter(ProfileActivity.this, responsee.getResp().getMessage());
                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.imgEditProfile: {
                focusFields();
                break;
            }
            case R.id.editProfile:{
                if (internet.isNetworkAvailable(this)) {
                    userViewModel.getUpdatedUser(binding.getOnProfileModel());
                    getData();
                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
        }
    }

    public void focusFields(){
        binding.txtUserName.setFocusable(true);
        binding.txtUserName.setClickable(true);
        binding.txtUserName.setEnabled(true);
//        binding.txtUserName.set

        binding.txtNumber.setFocusable(true);
        binding.txtNumber.setClickable(true);

        binding.txtAddress.setFocusable(true);
        binding.txtAddress.setClickable(true);

        binding.txtCity.setFocusable(true);
        binding.txtCity.setClickable(true);

        binding.txtPostCode.setFocusable(true);
        binding.txtPostCode.setClickable(true);

        binding.editProfile.setVisibility(View.VISIBLE);
        binding.editProfile.setText("Update Profile");
    }

    public void unFocusFields(){
        binding.txtUserName.setFocusable(false);
        binding.txtUserName.setClickable(false);

        binding.txtNumber.setFocusable(false);
        binding.txtNumber.setClickable(false);

        binding.txtAddress.setFocusable(false);
        binding.txtAddress.setClickable(false);

        binding.txtCity.setFocusable(false);
        binding.txtCity.setClickable(false);

        binding.txtPostCode.setFocusable(false);
        binding.txtPostCode.setClickable(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userViewModel.clear();
    }
}