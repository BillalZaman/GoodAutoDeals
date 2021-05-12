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
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartThreeBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.SellViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class SellMyCarPartThreeActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    SellViewModel viewModel;
    private ActivitySellMyCarPartThreeBinding binding;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_three);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(SellViewModel.class);

        init();
    }

    private void init() {
        binding.setOnClick(this);
        getLoadingStatus();
        getCarPrice();
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

    private void getCarPrice() {
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
                    uiHelper.showLongToastInCenter(SellMyCarPartThreeActivity.this, response.getResp().getMessage());
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
            case R.id.btnNext: {
                if (validation()) {
                    uiHelper.openActivity(this, SellMyCarPartFourActivity.class);
                    PreferenceHelper.getInstance().setString(ConstUtils.PRICE, binding.edtDemand.getText().toString());
                }
                break;
            }
        }
    }

    private boolean validation() {
        boolean check = true;
        binding.txtDemand.setError(null);

        if (binding.edtDemand.getText().toString().isEmpty()) {
            binding.txtDemand.setError("Price field cannot be empty");
            check = false;
        }
        return check;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}