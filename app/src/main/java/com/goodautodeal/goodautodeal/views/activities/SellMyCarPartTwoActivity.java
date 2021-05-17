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
import com.goodautodeal.goodautodeal.database.DatabaseHelper;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartTwoBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.SpecialSharedPrefHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.SellViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.CarDetailAdapter;
import com.goodautodeal.goodautodeal.database.table.AdSmmtDetailsModel;
import com.goodautodeal.goodautodeal.views.models.AdDimensionsModel;
import com.goodautodeal.goodautodeal.views.models.AdGeneralModel;
import com.goodautodeal.goodautodeal.views.models.AdVehicleHistoryModel;
import com.goodautodeal.goodautodeal.views.models.AdVehicleRegistrationModel;
import com.goodautodeal.goodautodeal.views.models.CarDetailModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

public class SellMyCarPartTwoActivity extends AppCompatActivity {
    private final ArrayList<CarDetailModel> data = new ArrayList<>();
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    SellViewModel viewModel;
    @Inject
    Internet internet;
    private ActivitySellMyCarPartTwoBinding binding;
    private CarDetailAdapter adapter;
    private String dynamicVRM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_two);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(SellViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        adapter = new CarDetailAdapter(this);
        getLoadingStatus();
        binding.textViewVRM.setText(PreferenceHelper.getInstance().getString(ConstUtils.VRM,""));
        binding.textViewMileage.setText(PreferenceHelper.getInstance().getString(ConstUtils.Mileage,"") +  "miles");
        dynamicVRM = getIntent().getStringExtra(ConstUtils.ValueKey);
        getCarDetail();

//        binding.recyclerview.setAdapter(adapter);
//        data.add(new CarDetailModel("Engine", "2.5L"));
//        adapter.setData(data);
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
        viewModel.getUserData().observe(this, response -> {

            if (response.getResp().getStatusCode().equalsIgnoreCase("success")) {
                binding.txtMileage.setText(PreferenceHelper.getInstance().getString(ConstUtils.Mileage,""));
                binding.setOnCarSmmtDetail(response.getResp().getDataItems().getAdSmmtDetailsModel());
                binding.setOnCarVehicleRegistration(response.getResp().getDataItems().getAdVehicleRegistrationModel());
                binding.setOnCarDimension(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdDimensionsModel());
                binding.setOnCarGeneral(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdGeneralModel());
                binding.setOnCarVehicleHistory(response.getResp().getDataItems().getAdVehicleHistoryModel());
                binding.txtBHP.setText(Integer.toString(
                        response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdPerfomanceModel().getPower().getBhp()));
                binding.txtExtraurban.setText((String.valueOf(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdConsumptionModel().
                        getAdExtraUrbanModel().getMpg())));

                binding.txturbancold.setText((String.valueOf(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdConsumptionModel().
                        getAdUrbanColdModel().getMpg())));

                binding.txtcombined.setText((String.valueOf(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdConsumptionModel().
                        getAdCombinedModel().getMpg())));


                AdSmmtDetailsModel adSmmtDetailsModel;
                adSmmtDetailsModel = new AdSmmtDetailsModel(
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getRange(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getMarque(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getFuelType(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getEngineCapacity(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getModelVariant(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getNumberOfGears(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getNominalEngineCapacity(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getTransmission(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getBodyStyle(),
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getNumberOfDoors());
//                    adSmmtDetailsModel.add(favouriteModel);

                String adTitle = response.getResp().getDataItems().getAdSmmtDetailsModel().getMarque()+
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getRange()+
                        response.getResp().getDataItems().getAdSmmtDetailsModel().getModelVariant();
                PreferenceHelper.getInstance().setString(ConstUtils.ADName, adTitle);

//                    DatabaseHelper.getInstance(SellMyCarPartTwoActivity.this).gadDao().insertSmmtDetail(adSmmtDetailsModel);
//
//                    if (DatabaseHelper.getInstance(SellMyCarPartTwoActivity.this).gadDao().getSmmtDetal()!=null){
//                        uiHelper.showLongToastInCenter(SellMyCarPartTwoActivity.this, "test" +
//                                DatabaseHelper.getInstance(SellMyCarPartTwoActivity.this).gadDao().getSmmtDetal().get(0).getBodyStyle()
//                        );
//
//                    }

                ArrayList<AdSmmtDetailsModel> getAdSmmtModel = new ArrayList<>();
                getAdSmmtModel.add(response.getResp().getDataItems().getAdSmmtDetailsModel());
                SpecialSharedPrefHelper.getInstance().saveList(getAdSmmtModel, ConstUtils.SMMTDATA);

                ArrayList<AdVehicleRegistrationModel> getVehicleRegistration = new ArrayList<>();
                getVehicleRegistration.add(response.getResp().getDataItems().getAdVehicleRegistrationModel());
                SpecialSharedPrefHelper.getInstance().saveList(getAdSmmtModel, ConstUtils.VEHICLEREGISTRATION);

                ArrayList<AdDimensionsModel> getDimension = new ArrayList<>();
                getDimension.add(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdDimensionsModel());
                SpecialSharedPrefHelper.getInstance().saveList(getAdSmmtModel, ConstUtils.DIMENSION);

                ArrayList<AdGeneralModel> getGeneralData = new ArrayList<>();
                getGeneralData.add(response.getResp().getDataItems().getAdTechnicalDetailsModel().getAdGeneralModel());
                SpecialSharedPrefHelper.getInstance().saveList(getAdSmmtModel, ConstUtils.GENERALDATA);

                ArrayList<AdVehicleHistoryModel> getVehicleHistory = new ArrayList<>();
                getVehicleHistory.add(response.getResp().getDataItems().getAdVehicleHistoryModel());
                SpecialSharedPrefHelper.getInstance().saveList(getAdSmmtModel, ConstUtils.VEHICLEHISTORY);

            } else {
                uiHelper.showLongToastInCenter(SellMyCarPartTwoActivity.this, response.getResp().getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}