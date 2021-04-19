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
import com.goodautodeal.goodautodeal.databinding.ActivityProfileBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
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
    private UserInfoModel userInfoModels;

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
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {
                    if (response.getResp().getDataObject().getUserInfo() != null) {
                        uiHelper.showLongToastInCenter(ProfileActivity.this, response.getResp().getMessage());
                        binding.setOnProfileModel(response.getResp().getDataObject().getUserInfo());
                    }
                } else {
                    uiHelper.showLongToastInCenter(ProfileActivity.this, response.getResp().getMessage());
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
            case R.id.editProfile: {
                Toast.makeText(this, "Profile Edit", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userViewModel.clear();
    }
}