package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityAdsManagementBinding;
import com.goodautodeal.goodautodeal.fragments.DraftFragment;
import com.goodautodeal.goodautodeal.fragments.PendingFragment;
import com.goodautodeal.goodautodeal.fragments.PublishedFragment;
import com.goodautodeal.goodautodeal.fragments.RejectedFragment;
import com.goodautodeal.goodautodeal.fragments.SoldVehicleFragment;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class AdsManagementActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivityAdsManagementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ads_management);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setActivity(this);
        uiHelper.replaceFragment(this, R.id.container, new PublishedFragment());
        binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        binding.btnPublished.setTextColor(getResources().getColor(R.color.colorWhite));
        selectTab(1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btn_published: {
                uiHelper.replaceFragment(this, R.id.container, new PublishedFragment());
                binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                binding.btnPublished.setTextColor(getResources().getColor(R.color.colorWhite));
                selectTab(1);
                break;
            }
            case R.id.btn_pending: {
                uiHelper.replaceFragment(this, R.id.container, new PendingFragment());
                binding.btnPending.setBackgroundColor(getResources().getColor(R.color.yellow));
                binding.btnPending.setTextColor(getResources().getColor(R.color.colorWhite));
                selectTab(2);
                break;
            }
            case R.id.btn_rejected: {
                uiHelper.replaceFragment(this, R.id.container, new RejectedFragment());
                binding.btnRejected.setBackgroundColor(getResources().getColor(R.color.red));
                binding.btnRejected.setTextColor(getResources().getColor(R.color.colorWhite));
                selectTab(3);
                break;
            }
            case R.id.btn_sold: {
                uiHelper.replaceFragment(this, R.id.container, new SoldVehicleFragment());
                binding.btnSold.setBackgroundColor(getResources().getColor(R.color.colorLightBlack));
                binding.btnSold.setTextColor(getResources().getColor(R.color.colorWhite));
                selectTab(4);
                break;
            }
            case R.id.tab_draft: {
                uiHelper.replaceFragment(this, R.id.container, new DraftFragment());
                binding.tabDraft.setBackgroundColor(getResources().getColor(R.color.draft));
                binding.tabDraft.setTextColor(getResources().getColor(R.color.colorWhite));
                selectTab(5);
                break;
            }
        }
    }

    private void selectTab(int position) {
        switch (position) {
            case 1: {
                //published
                binding.btnPending.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPending.setTextColor(getResources().getColor(R.color.grey));
                binding.btnRejected.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnRejected.setTextColor(getResources().getColor(R.color.grey));
                binding.btnSold.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnSold.setTextColor(getResources().getColor(R.color.grey));
                binding.tabDraft.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.tabDraft.setTextColor(getResources().getColor(R.color.grey));

                break;
            }
            case 2: {
                //pending
                binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPublished.setTextColor(getResources().getColor(R.color.grey));
                binding.btnRejected.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnRejected.setTextColor(getResources().getColor(R.color.grey));
                binding.btnSold.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnSold.setTextColor(getResources().getColor(R.color.grey));
                binding.tabDraft.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.tabDraft.setTextColor(getResources().getColor(R.color.grey));

                break;
            }
            case 3: {
                //rejected
                binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPublished.setTextColor(getResources().getColor(R.color.grey));
                binding.btnPending.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPending.setTextColor(getResources().getColor(R.color.grey));
                binding.btnSold.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnSold.setTextColor(getResources().getColor(R.color.grey));
                binding.tabDraft.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.tabDraft.setTextColor(getResources().getColor(R.color.grey));
                break;
            }
            case 4: {
                //sold
                binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPublished.setTextColor(getResources().getColor(R.color.grey));
                binding.btnPending.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPending.setTextColor(getResources().getColor(R.color.grey));
                binding.btnRejected.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnRejected.setTextColor(getResources().getColor(R.color.grey));
                binding.tabDraft.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.tabDraft.setTextColor(getResources().getColor(R.color.grey));

                break;
            }
            case 5: {
                // draft
                binding.btnPublished.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPublished.setTextColor(getResources().getColor(R.color.grey));
                binding.btnRejected.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnRejected.setTextColor(getResources().getColor(R.color.grey));
                binding.btnSold.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnSold.setTextColor(getResources().getColor(R.color.grey));
                binding.btnPending.setBackgroundColor(getResources().getColor(R.color.unSelectTabColor));
                binding.btnPending.setTextColor(getResources().getColor(R.color.grey));
                break;
            }
        }
    }
}