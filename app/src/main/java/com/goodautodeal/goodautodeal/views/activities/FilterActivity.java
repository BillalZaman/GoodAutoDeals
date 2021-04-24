package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityFilterBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.FilterClickInterface;
import com.goodautodeal.goodautodeal.views.adapters.FiltersAdapter;
import com.goodautodeal.goodautodeal.views.models.FiltersModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class FilterActivity extends AppCompatActivity implements FilterClickInterface {
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
        data.add(new FiltersModel(getString(R.string.body_)));
        data.add(new FiltersModel(getString(R.string.transmission_)));
        data.add(new FiltersModel(getString(R.string.emission_)));
        data.add(new FiltersModel(getString(R.string.colors_)));
        data.add(new FiltersModel(getString(R.string.numdoors_)));
        data.add(new FiltersModel(getString(R.string.numseats_)));
        data.add(new FiltersModel(getString(R.string.fuel_)));
        data.add(new FiltersModel(getString(R.string.capacity_engine)));
        data.add(new FiltersModel(getString(R.string.fuel_tank)));
        data.add(new FiltersModel(getString(R.string.bhp)));
        data.add(new FiltersModel(getString(R.string.axele_)));
        data.add(new FiltersModel(getString(R.string.tax_)));

        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }

    @Override
    public void filterClick(String filter) {
        if (filter.equalsIgnoreCase(getString(R.string.body_))){
            
        } else if (filter.equalsIgnoreCase(getString(R.string.transmission_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.emission_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.colors_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.numdoors_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.numseats_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.fuel_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.capacity_engine))){

        } else if (filter.equalsIgnoreCase(getString(R.string.fuel_tank))){

        } else if (filter.equalsIgnoreCase(getString(R.string.bhp))){

        } else if (filter.equalsIgnoreCase(getString(R.string.axele_))){

        } else if (filter.equalsIgnoreCase(getString(R.string.tax_))){

        }
    }
}