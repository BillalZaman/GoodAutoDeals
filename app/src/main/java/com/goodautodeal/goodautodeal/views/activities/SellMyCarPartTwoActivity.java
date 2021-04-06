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
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartTwoBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.CarDetailAdapter;
import com.goodautodeal.goodautodeal.views.models.CarDetailModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

public class SellMyCarPartTwoActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    @Inject
    Internet internet;
    private ActivitySellMyCarPartTwoBinding binding;
    private final ArrayList<CarDetailModel> data = new ArrayList<>();
    private CarDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_two);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        adapter = new CarDetailAdapter(this);
        getLoadingStatus();
        getCarDetail();
        binding.recyclerview.setAdapter(adapter);
        data.add(new CarDetailModel("Engine", "2.5L"));

        adapter.setData(data);
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
            case R.id.btnNext: {
                uiHelper.openActivity(this, SellMyCarPartThreeActivity.class);
                break;
            }
        }
    }

    private void getCarDetail() {
        if (internet.isNetworkAvailable(this)) {
            viewModel.getCarDetail();
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
                    binding.setOnCarTechnicalDetail(response.getResp().getDataItems().getAdTechnicalDetailsModel());
                    binding.setOnCarSmmtDetail(response.getResp().getDataItems().getAdSmmtDetailsModel());
                    binding.setOnCarVehicleRegistration(response.getResp().getDataItems().getAdVehicleRegistrationModel());
                    binding.setOnCarDimension(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdDimensionsModel());
                    binding.setOnCarGeneral(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdGeneralModel());
                    binding.setOnCarVehicleHistory(response.getResp().getDataItems().getAdVehicleHistoryModel());
//                    binding.txtBHP.setText(Integer.toString(
//                            response.getResp().getDataItems().getAdPerfomanceModel().getPower().getBhp()));
//                    binding.setOnCarUrban(response.getResp().getDataItems().getAdConsumptionModel().getAdExtraUrbanModel());
//                    binding.setOnCarUrbanCold(response.getResp().getDataItems().getAdConsumptionModel().getAdUrbanColdModel());
                } else {
                    uiHelper.showLongToastInCenter(SellMyCarPartTwoActivity.this, response.getMessage());
                }
            }
        });
    }

}