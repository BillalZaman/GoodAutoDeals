package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.database.DatabaseHelper;
import com.goodautodeal.goodautodeal.database.table.FavouriteModel;
import com.goodautodeal.goodautodeal.databinding.ActivityFavouriteBinding;
import com.goodautodeal.goodautodeal.views.adapters.FavAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {
    private ActivityFavouriteBinding binding;
    private ArrayList<FavouriteModel> data = new ArrayList<>();
    private FavAdapter favAdapter;

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
        favAdapter = new FavAdapter(this);
        data = (ArrayList<FavouriteModel>) DatabaseHelper.getInstance(this).gadDao().getFavouriteModel();
        favAdapter.setData(data);
        binding.recyclerview.setAdapter(favAdapter);
    }
}