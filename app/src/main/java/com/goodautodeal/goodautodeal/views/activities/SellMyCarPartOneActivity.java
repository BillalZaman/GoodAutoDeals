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
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartOneBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class SellMyCarPartOneActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartOneBinding binding;
    private String isActivityName;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    @Inject
    Internet internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_one);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);

        init();
    }

    private void init() {
        getLoadingStatus();
        binding.setOnClick(this);
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);

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
            case R.id.btnFindDetail: {

                if (internet.isNetworkAvailable(this)){
                    if (validation()){

                        if (isActivityName.equalsIgnoreCase("sell my car")) {
                            viewModel.getCheckVRMDuplication(binding.edtMileage.getText().toString());
                            getData();

                        } else if (isActivityName.equalsIgnoreCase("value your car")) {

                            uiHelper.openActivityAndSendValuewithData(SellMyCarPartOneActivity.this, ValueYourCarActivity.class,
                                    "user", binding.edtVRM.getText().toString());

                        } else if (isActivityName.equalsIgnoreCase("dealervalue")) {
                            uiHelper.openActivityAndSendValuewithData(SellMyCarPartOneActivity.this, ValueYourCarActivity.class,
                                    "dealer", binding.edtVRM.getText().toString());
                        }

                    }
                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
        }
    }

    private void getData() {
        viewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == ConstUtils.SUCCESS_CODE) {

                    uiHelper.openActivity(SellMyCarPartOneActivity.this, SellMyCarPartTwoActivity.class);
                    PreferenceHelper.getInstance().setString(ConstUtils.VRM, binding.edtVRM.getText().toString());


//                    if (isActivityName.equalsIgnoreCase("sell my car")) {
//
//                    } else if (isActivityName.equalsIgnoreCase("value your car")) {
//                        uiHelper.openActivityAndSendValuewithData(SellMyCarPartOneActivity.this, ValueYourCarActivity.class,
//                                "user", binding.edtVRM.getText().toString());
//
//                    } else if (isActivityName.equalsIgnoreCase("dealervalue")) {
//                        uiHelper.openActivityAndSendValuewithData(SellMyCarPartOneActivity.this, ValueYourCarActivity.class,
//                                "dealer", binding.edtVRM.getText().toString());
//                    } else {
//                        uiHelper.openActivity(SellMyCarPartOneActivity.this, SellMyCarPartTwoActivity.class);
//                    }

                } else {

                    uiHelper.showLongToastInCenter(SellMyCarPartOneActivity.this,
                            "This car already exist in our database");
                }
            }
        });
    }

    private boolean validation() {
        boolean check = true;
        binding.txtVRM.setError(null);
        binding.txtMileage.setError(null);

        if (binding.edtVRM.getText().toString().isEmpty()) {
            binding.txtVRM.setError("VRM Field cannot be empty");
            check = false;
        } else if (binding.edtMileage.getText().toString().isEmpty()) {
            binding.txtMileage.setError("Mileage Field cannot be empty");
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