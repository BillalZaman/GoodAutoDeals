package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartFourBinding;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import java.util.ArrayList;

import javax.inject.Inject;

public class SellMyCarPartFourActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartFourBinding binding;
    private ArrayList<String> conditionList = new ArrayList<String>();
    private ArrayAdapter<String> conditionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_four);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {
        binding.setOnClick(this);

        if (PreferenceHelper.getInstance().getString(ConstUtils.ADName,"")!=null){
            binding.txtDemand.setText(PreferenceHelper.getInstance().getString(ConstUtils.PRICE,""));
            binding.Title.setText(PreferenceHelper.getInstance().getString(ConstUtils.ADName,""));
        }

        conditionList.add("New");
        conditionList.add("Used");
        if (conditionList!=null) {
            conditionAdapter = new ArrayAdapter<String>(this,
                    R.layout.custom_spinner_design, conditionList);
            conditionAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            binding.edtCondition.setAdapter(conditionAdapter);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnNext: {
//                uiHelper.openActivity(this, PackagesActivity.class);
                uiHelper.openActivity(this, SellMyCarPartFiveActivity.class);
                break;
            }
            case R.id.btnComfort: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "comfort");
                break;
            }
            case R.id.btnSafety: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "safety");
                break;
            }
            case R.id.btnExterior: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "exterior");
                break;
            }
            case R.id.btnInterior: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "interior");
                break;
            }
            case R.id.btnOthers: {
                uiHelper.openActivityAndSendValue(this, AccessoriesActivity.class, "other");
                break;
            }
        }
    }
}