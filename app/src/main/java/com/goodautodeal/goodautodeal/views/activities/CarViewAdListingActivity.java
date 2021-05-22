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
import com.goodautodeal.goodautodeal.views.adapters.AdFeaturedAdapter;
import com.goodautodeal.goodautodeal.views.adapters.GeneralAdViewAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.AdFeatureModel;
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
    private ArrayList<AdFeatureModel> data_Featured = new ArrayList<>();
    private GeneralAdViewAdapter generalAdViewAdapter;
    private AdFeaturedAdapter adFeaturedAdapter;
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
        adFeaturedAdapter = new AdFeaturedAdapter(this);

        if (isActivityName.equalsIgnoreCase("used car")) {
            binding.textView.setText(getString(R.string.used_car));
            if (internet.isNetworkAvailable(this)) {
                viewModel.getUsedCar();
                getData();

            } else {
                uiHelper.showLongToastInCenter(this, getResources().getString(R.string.no_interrnet_connection));

            }
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

                    if (response.getResp().getDataObject().getFeatureAd() != null) {
                        data_Featured = response.getResp().getDataObject().getFeatureAd();
                        adFeaturedAdapter.setData(data_Featured);
                        binding.recyclerFeatured.setAdapter(adFeaturedAdapter);

                    }
                    if (response.getResp().getDataObject().getNewCarAds() != null) {
                        data = response.getResp().getDataObject().getNewCarAds();
                        generalAdViewAdapter.setData(data);
                        binding.recyclerview.setAdapter(generalAdViewAdapter);
                    }

                    if (response.getResp().getDataObject().getFeatureAd().isEmpty()
                            && response.getResp().getDataObject().getNewCarAds().isEmpty()){

                        binding.recyclerFeatured.setVisibility(View.GONE);
                        binding.recyclerview.setVisibility(View.GONE);
                        binding.textView32.setVisibility(View.VISIBLE);
                        binding.textView34.setVisibility(View.VISIBLE);

                    }
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
            case R.id.textView34:{
                finish();
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