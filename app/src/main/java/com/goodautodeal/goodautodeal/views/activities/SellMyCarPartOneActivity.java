package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartOneBinding;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartOneBindingImpl;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

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
                    uiHelper.openActivityAndSendValue(this, ValueYourCarActivity.class,"user");
                } else if (isActivityName.equalsIgnoreCase("dealervalue")){
                    uiHelper.openActivityAndSendValue(this, ValueYourCarActivity.class,"dealer");
                } else {
                    uiHelper.openActivity(this, SellMyCarPartTwoActivity.class);
                }
                break;
            }
        }
    }
}