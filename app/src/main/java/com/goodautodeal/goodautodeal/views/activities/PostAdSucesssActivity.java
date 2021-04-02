package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityPostAdSucesssBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class PostAdSucesssActivity extends AppCompatActivity {
    private ActivityPostAdSucesssBinding binding;
    @Inject
    UIHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_post_ad_sucesss);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnViewAds:{
                uiHelper.openActivity(this, AdsManagementActivity.class);
                break;
            }
        }
    }
}