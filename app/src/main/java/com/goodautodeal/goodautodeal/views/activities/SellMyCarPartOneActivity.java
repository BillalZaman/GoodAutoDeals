package com.goodautodeal.goodautodeal.views.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartOneBinding;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartOneBindingImpl;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class SellMyCarPartOneActivity extends AppCompatActivity {
    private ActivitySellMyCarPartOneBinding binding;
    @Inject
    UIHelper uiHelper;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sell_my_car_part_one);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnFindDetail:{
                if (isActivityName.equalsIgnoreCase("sell my car")){
                    uiHelper.openActivity(this, SellMyCarPartTwoActivity.class);
                } else if (isActivityName.equalsIgnoreCase("value your car")){
                    uiHelper.openActivityAndSendValuewithData(this, ValueYourCarActivity.class,
                            "user",binding.edtVRM.getText().toString());
                } else if (isActivityName.equalsIgnoreCase("dealervalue")){
                    uiHelper.openActivityAndSendValuewithData(this, ValueYourCarActivity.class,
                            "dealer", binding.edtVRM.getText().toString());
                } else {
                    uiHelper.openActivity(this, SellMyCarPartTwoActivity.class);
                }
                break;
            }
        }
    }
}