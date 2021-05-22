package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
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
import com.goodautodeal.goodautodeal.databinding.ActivityDealerMainBinding;
import com.goodautodeal.goodautodeal.fragments.DashboardFragment;
import com.goodautodeal.goodautodeal.fragments.MoreFragment;
import com.goodautodeal.goodautodeal.fragments.NotificationFragment;
import com.goodautodeal.goodautodeal.fragments.ProfileFragment;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.DealerMoreInterface;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.DealerViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class DealerMainActivity extends AppCompatActivity implements DealerMoreInterface {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    private ActivityDealerMainBinding binding;
    private AdPostingViewModel viewModel;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dealer_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);


        init();
    }

    private void init() {
        binding.setOnDealerClick(this);
        getLoadingStatus();
        uiHelper.replaceFragment(this, R.id.frameLayout, new DashboardFragment());
    }

    private void getLoadingStatus() {
        viewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
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
            case R.id.btn_dashboard: {
                uiHelper.replaceFragment(this, R.id.frameLayout, new DashboardFragment());
                break;
            }
            case R.id.profile_btn: {
                uiHelper.replaceFragment(this, R.id.frameLayout, new ProfileFragment());
                break;
            }
            case R.id.btn_notification: {
                uiHelper.replaceFragment(this, R.id.frameLayout, new NotificationFragment());
                break;
            }
            case R.id.btnMore: {
                uiHelper.replaceFragment(this, R.id.frameLayout, new MoreFragment());
                break;
            }
        }
    }

    @Override
    public void itemClick(int position) {
        switch (position) {
//            case 0: {
//                //sell my car
//                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class, "dealermore");
//                break;
//            }
            case 0: {
                // value your car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class, "dealervalue");
                break;
            }
            case 1: {
                //change password
                uiHelper.openActivity(this, ChangePasswordActivity.class);
                break;
            }
//            case 2: {
//                //faq
//                uiHelper.openActivity(this, FAQListActivity.class);
//                break;
//            }
            case 2: {
                //contact us
                uiHelper.openActivity(this, ContactUsActivity.class);
                break;
            }
            case 3: {
                //logout
                if (internet.isNetworkAvailable(this)) {
                    viewModel.getLogout();
                    getData();

                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
        }
    }

    private void getData() {
        viewModel.getUserData().observe(this, response -> {
            if (response.getResp().getCode() == 1 &&
                    response.getResp().getSuccess().equalsIgnoreCase("success")) {
                uiHelper.showLongToastInCenter(DealerMainActivity.this, "Logout Successfully");
                PreferenceHelper.getInstance().clearAllPreferences();
                PreferenceHelper.getInstance().removeall();
                PreferenceHelper.getInstance().removePreference(ConstUtils.IS_OPON_FIRST_TIME);
                PreferenceHelper.getInstance().removePreference(ConstUtils.isUserLogin);
                PreferenceHelper.getInstance().removePreference(ConstUtils.isDealerLogin);
                uiHelper.openAndClearActivity(DealerMainActivity.this, MainActivity.class);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}