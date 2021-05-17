package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartFourBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

public class SellMyCarPartFourActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    @Inject
    Internet internet;
    private ActivitySellMyCarPartFourBinding binding;
    private ArrayList<String> conditionList = new ArrayList<String>();
    private ArrayAdapter<String> conditionAdapter;
    private String condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_four);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        getLoadingStatus();

        if (PreferenceHelper.getInstance().getString(ConstUtils.ADName,"")!=null){
            binding.txtDemand.setText(PreferenceHelper.getInstance().getString(ConstUtils.PRICE,""));
            binding.Title.setText(PreferenceHelper.getInstance().getString(ConstUtils.ADName,""));
        }

        conditionList.add("New");
        conditionList.add("Used");
        if (conditionList!=null) {
            conditionAdapter = new ArrayAdapter<String>(this,
                    R.layout.custom_spinner_design, conditionList);
            conditionAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            binding.edtCondition.setAdapter(conditionAdapter);
        }

        binding.edtCondition.setOnItemClickListener((parent, view, position, id) -> {
            if (position==0){
                condition = "New";
            } else {
                condition = "Used";
            }
        });
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

                if (internet.isNetworkAvailable(this)){
                    viewModel.getAdSetData(PreferenceHelper.getInstance().getString(ConstUtils.PRICE,""),
                            PreferenceHelper.getInstance().getString(ConstUtils.ADName,""),
                            condition, "Yes",
                            binding.CarManufacturing.getText().toString(),binding.CarMOT.getText().toString(),
                            binding.CarRoadTax.getText().toString(),binding.CarCarTaxExpire.getText().toString(),
                            binding.CarBoot.getText().toString(),binding.edtAdditionalDesc.getText().toString(),
                            PreferenceHelper.getInstance().getString(ConstUtils.VRM,""),
                            PreferenceHelper.getInstance().getString(ConstUtils.Mileage,""));
                    getAdData();
                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
//                uiHelper.openActivity(this, PackagesActivity.class);
//                uiHelper.openActivity(this, SellMyCarPartFiveActivity.class);
                break;
            }
            case R.id.btnComfort: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "comfort");
                break;
            }
            case R.id.btnSafety: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "safety");
                break;
            }
            case R.id.btnExterior: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "exterior");
                break;
            }
            case R.id.btnInterior: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "interior");
                break;
            }
            case R.id.btnOthers: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "other");
                break;
            }
        }
    }

    private void getAdData() {
        viewModel.getUserData().observe(this, response -> {
            if (response.getResp().getCode() == 200 &&
                    response.getResp().getSuccess().equalsIgnoreCase("success")) {

                uiHelper.openActivity(this, SellMyCarPartFiveActivity.class);

                PreferenceHelper.getInstance().setString(ConstUtils.silver, String.valueOf(
                        response.getResp().getDataObject().getPackages().getSilver()));
                PreferenceHelper.getInstance().setString(ConstUtils.gold, String.valueOf(
                        response.getResp().getDataObject().getPackages().getGold()));
                PreferenceHelper.getInstance().setString(ConstUtils.diamond, String.valueOf(
                        response.getResp().getDataObject().getPackages().getDiamond()));
                PreferenceHelper.getInstance().setString(ConstUtils.platinum, String.valueOf(
                        response.getResp().getDataObject().getPackages().getPlatinum()));

            } else {
                uiHelper.showLongToastInCenter(SellMyCarPartFourActivity.this, response.getResp().getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }
}