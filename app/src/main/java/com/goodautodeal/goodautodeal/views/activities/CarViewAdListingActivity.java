package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityCarViewAdListingBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class CarViewAdListingActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivityCarViewAdListingBinding binding;
    private ArrayList<PremiumAdsModel> data = new ArrayList<>();
    private PremiumAdapter premiumAdapter;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_car_view_ad_listing);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnClick(this);
        setRecyclerView();
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);

        if (isActivityName.equalsIgnoreCase("used car")) {
            binding.textView.setText(getString(R.string.used_car));
        } else {
            binding.textView.setText(getString(R.string.new_car));
        }
    }

    private void setRecyclerView() {
        premiumAdapter = new PremiumAdapter(this);
        for (int i = 0; i <= 10; i++) {
            data.add(new PremiumAdsModel("BMW 520D M SPORT AUTO", "£900", "2020",
                    "1000cc", "500cc"));
        }
//        premiumAdapter.setData(data);
        binding.recyclerview.setAdapter(premiumAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.imgFilter: {
                uiHelper.openActivity(this, FilterActivity.class);
                break;
            }
        }
    }
}