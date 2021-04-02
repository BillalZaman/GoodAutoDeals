package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartFiveBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class SellMyCarPartFiveActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartFiveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sell_my_car_part_five);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {
        binding.btnPublishedNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivity(SellMyCarPartFiveActivity.this, PostAdSucesssActivity.class);
            }
        });
    }
}