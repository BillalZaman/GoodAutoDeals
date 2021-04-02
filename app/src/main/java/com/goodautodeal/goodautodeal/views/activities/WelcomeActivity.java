package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityWelcomeBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;
    @Inject
    UIHelper uiHelper;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnLoginClick(this);
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);

        if (isActivityName.equalsIgnoreCase("user")){
            uiHelper.openActivityAndSendValue(this, LoginActivity.class,"user");
        }
    }

    public void onLoginClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnSignup:{
                uiHelper.openActivity(this, RegistrationActivity.class);
                break;
            }
            case R.id.btnLogin:{
                uiHelper.openActivity(this, LoginActivity.class);
                break;
            }
        }
    }
}