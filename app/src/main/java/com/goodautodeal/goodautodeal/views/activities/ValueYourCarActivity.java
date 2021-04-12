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
import com.goodautodeal.goodautodeal.databinding.ActivityValueYourCarBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class ValueYourCarActivity extends AppCompatActivity {
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    private ActivityValueYourCarBinding binding;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_value_your_car);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);

        getLoadingStatus();

        if (isActivityName.equalsIgnoreCase("user")) {
            binding.txtDealerEscort.setVisibility(View.GONE);
            binding.txtDealerEscortPrice.setVisibility(View.GONE);
            binding.txtTradeAverage.setVisibility(View.GONE);
            binding.txtTradeAveragePrice.setVisibility(View.GONE);
            binding.txtTradePoor.setVisibility(View.GONE);
            binding.txtTradePoorPrice.setVisibility(View.GONE);
        } else {
            binding.txtDealerEscort.setVisibility(View.VISIBLE);
            binding.txtDealerEscortPrice.setVisibility(View.VISIBLE);
            binding.txtTradeAverage.setVisibility(View.VISIBLE);
            binding.txtTradeAveragePrice.setVisibility(View.VISIBLE);
            binding.txtTradePoor.setVisibility(View.VISIBLE);
            binding.txtTradePoorPrice.setVisibility(View.VISIBLE);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnViewDetail: {
                getValueYourCar();
            }
        }
    }

    private void getValueYourCar() {
        if (internet.isNetworkAvailable(this)) {
            viewModel.getValueYourCar();
            getData();

        } else {
            uiHelper.showLongToastInCenter(this, getResources().getString(R.string.no_interrnet_connection));

        }
    }

    private void getData() {
        viewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getStatusCode().equalsIgnoreCase("success")) {
                    binding.setOnModel(response.getResp().getDataItems().getValuationList());
                } else {
                    uiHelper.showLongToastInCenter(ValueYourCarActivity.this, response.getResp().getMessage());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}