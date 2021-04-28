package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityFAQListBinding;
import com.goodautodeal.goodautodeal.views.adapters.FaqListAdapter;
import com.goodautodeal.goodautodeal.views.models.FaqListModel;

import java.util.ArrayList;

public class FAQListActivity extends AppCompatActivity {
    private ActivityFAQListBinding binding;
    private ArrayList<FaqListModel> data = new ArrayList<>();
    private FaqListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_f_a_q_list);

        init();
    }

    private void init() {

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter = new FaqListAdapter(this);

        data.add(new FaqListModel("Login and Registration"));
        data.add(new FaqListModel("Used Car Ads"));
        data.add(new FaqListModel("Buying"));
        data.add(new FaqListModel("Selling"));
        data.add(new FaqListModel("Miscellaneous"));

        adapter.setList(data);
        binding.recyclerview.setAdapter(adapter);
    }
}