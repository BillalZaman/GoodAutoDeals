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
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityCarViewAdListingBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.GeneralAdViewAdapter;
import com.goodautodeal.goodautodeal.views.models.AdGeneralViewModel;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

public class CarViewAdListingActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    private ActivityCarViewAdListingBinding binding;
    private ArrayList<AdGeneralViewModel> data = new ArrayList<>();
    private GeneralAdViewAdapter generalAdViewAdapter;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_car_view_ad_listing);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        getLoadingStatus();
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);
        generalAdViewAdapter = new GeneralAdViewAdapter(this);

        if (isActivityName.equalsIgnoreCase("used car")) {
            binding.textView.setText(getString(R.string.used_car));
        } else {
            binding.textView.setText(getString(R.string.new_car));
            if (internet.isNetworkAvailable(this)) {
                viewModel.getNewCar();
                getData();

            } else {
                uiHelper.showLongToastInCenter(this, getResources().getString(R.string.no_interrnet_connection));

            }
        }
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


    private void getData() {
        viewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 200 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {

                        data = response.getResp().getDataObject().getNewCarAds();
                        generalAdViewAdapter.setData(data);
                        binding.recyclerview.setAdapter(generalAdViewAdapter);

                } else {
                    uiHelper.showLongToastInCenter(CarViewAdListingActivity.this, response.getResp().getMessage());
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
            case R.id.imgFilter: {
                uiHelper.openActivity(this, FilterActivity.class);
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}