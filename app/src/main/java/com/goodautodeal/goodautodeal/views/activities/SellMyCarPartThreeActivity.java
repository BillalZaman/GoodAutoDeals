package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartThreeBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class SellMyCarPartThreeActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartThreeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sell_my_car_part_three);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {
        binding.setOnClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnNext:{
                uiHelper.openActivity(this, SellMyCarPartFourActivity.class);
                break;
            }
        }
    }
}