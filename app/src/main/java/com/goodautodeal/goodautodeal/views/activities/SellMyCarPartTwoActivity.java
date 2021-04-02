package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartTwoBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.adapters.CarDetailAdapter;
import com.goodautodeal.goodautodeal.views.models.CarDetailModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class SellMyCarPartTwoActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartTwoBinding binding;
    private ArrayList<CarDetailModel> data = new ArrayList<>();
    private CarDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sell_my_car_part_two);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {
        binding.setOnClick(this);
        adapter = new CarDetailAdapter(this);
        for (int i=0; i<=25; i++){
            data.add(new CarDetailModel("Engine","2.5L"));
        }
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnNext:{
                uiHelper.openActivity(this, SellMyCarPartThreeActivity.class);
                break;
            }
        }
    }
}