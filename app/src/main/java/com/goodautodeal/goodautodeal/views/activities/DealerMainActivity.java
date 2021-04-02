package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityDealerMainBinding;
import com.goodautodeal.goodautodeal.fragments.DashboardFragment;
import com.goodautodeal.goodautodeal.fragments.MoreFragment;
import com.goodautodeal.goodautodeal.fragments.NotificationFragment;
import com.goodautodeal.goodautodeal.fragments.ProfileFragment;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.DealerMoreInterface;

import javax.inject.Inject;

public class DealerMainActivity extends AppCompatActivity implements DealerMoreInterface {
    private ActivityDealerMainBinding binding;
    @Inject
    UIHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dealer_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnDealerClick(this);
        uiHelper.replaceFragment(this, R.id.frameLayout, new DashboardFragment());
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_dashboard:{
                uiHelper.replaceFragment(this, R.id.frameLayout, new DashboardFragment());
                break;
            }
            case R.id.profile_btn:{
                uiHelper.replaceFragment(this, R.id.frameLayout, new ProfileFragment());
                break;
            }
            case R.id.btn_notification:{
                uiHelper.replaceFragment(this, R.id.frameLayout, new NotificationFragment());
                break;
            }
            case R.id.btnMore:{
                uiHelper.replaceFragment(this, R.id.frameLayout, new MoreFragment());
                break;
            }
        }
    }

    @Override
    public void itemClick(int position) {
        switch (position){
            case 0:{
                //sell my car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class,"dealermore");
                break;
            }
            case 1:{
                // value your car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class,"dealervalue");
                break;
            }
            case 2:{
                // car history
                uiHelper.showLongToastInCenter(this, "Working In Progress");
                break;
            }
            case 3:{
                //change password
                uiHelper.openActivity(this, ChangePasswordActivity.class);
                break;
            }
            case 4:{
                //faq
                uiHelper.openActivity(this, FAQListActivity.class);
                break;
            }
            case 5:{
                //contact us
                uiHelper.openActivity(this, ContactUsActivity.class);
                break;
            }
            case 6:{
                //logout

                break;
            }
        }
    }
}