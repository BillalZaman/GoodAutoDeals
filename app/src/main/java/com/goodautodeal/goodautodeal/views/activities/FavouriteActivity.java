package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityFavouriteBinding;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {
    private ActivityFavouriteBinding binding;
    private ArrayList<PremiumAdsModel> data = new ArrayList<>();
    private PremiumAdapter premiumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favourite);
        init();
    }

    private void init() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        premiumAdapter = new PremiumAdapter(this);
        for (int i = 0; i <= 10; i++) {
            data.add(new PremiumAdsModel("BMW 520D M SPORT AUTO", "£900", "2020",
                    "1000cc", "500cc"));
        }
        premiumAdapter.setData(data);
        binding.recyclerview.setAdapter(premiumAdapter);
    }
}