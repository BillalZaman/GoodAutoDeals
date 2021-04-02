package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityDealersBinding;
import com.goodautodeal.goodautodeal.views.adapters.DealerAdapter;
import com.goodautodeal.goodautodeal.views.models.DealersModel;

import java.util.ArrayList;

public class DealersActivity extends AppCompatActivity {
    private ActivityDealersBinding binding;
    private ArrayList<DealersModel> data = new ArrayList<>();
    private DealerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dealers);

        init();
    }

    private void init() {
        setRecyclerView();
        binding.setOnClick(this);
    }

    private void setRecyclerView() {
        adapter = new DealerAdapter(this);
        for (int i=0;i<=20;i++) {
            data.add(new DealersModel("Good Auto Cars", "120 Cars", "34 Cliveland Street, Birmingham, B19 3SH"));
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
            case R.id.imgFilter:{
                Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}