package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityFilterBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.adapters.FiltersAdapter;
import com.goodautodeal.goodautodeal.views.models.FiltersModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class FilterActivity extends AppCompatActivity {
    private ActivityFilterBinding binding;
    private ArrayList<FiltersModel> data = new ArrayList<>();
    private FiltersAdapter adapter;
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        setFilterData();
    }

    private void setFilterData() {
        adapter = new FiltersAdapter(this);
        data.add(new FiltersModel("Body"));
        data.add(new FiltersModel("Transmission"));
        data.add(new FiltersModel("C02 Emission"));
        data.add(new FiltersModel("Colours"));
        data.add(new FiltersModel("Number of doors"));
        data.add(new FiltersModel("Number of seats"));
        data.add(new FiltersModel("Fuel Type"));
        data.add(new FiltersModel("Engine Capacity"));
        data.add(new FiltersModel("Fuel Tank Capacity"));
        data.add(new FiltersModel("BHP"));
        data.add(new FiltersModel("Driving Axele"));
        data.add(new FiltersModel("Road Tax"));

        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }
}