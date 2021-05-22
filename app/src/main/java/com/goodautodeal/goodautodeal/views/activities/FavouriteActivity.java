package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.database.DatabaseHelper;
import com.goodautodeal.goodautodeal.database.table.FavouriteModel;
import com.goodautodeal.goodautodeal.databinding.ActivityFavouriteBinding;
import com.goodautodeal.goodautodeal.views.adapters.FavAdapter;

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
        binding.setOnClick(this);
        data = (ArrayList<FavouriteModel>) DatabaseHelper.getInstance(this).gadDao().getFavouriteModel();

        if (data.size()!=0) {
            setRecyclerView();
        } else {
            binding.recyclerview.setVisibility(View.VISIBLE);
            binding.textView32.setVisibility(View.VISIBLE);
            binding.textView34.setVisibility(View.VISIBLE);
        }

    }

    private void setRecyclerView() {
        favAdapter = new FavAdapter(this);
        favAdapter.setData(data);
        binding.recyclerview.setAdapter(favAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.textView34: {
                finish();
                break;
            }
        }
    }
}