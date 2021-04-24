package com.goodautodeal.goodautodeal.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.FragmentDashboardBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.DealerViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.activities.AdsManagementActivity;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class DashboardFragment extends Fragment {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    private FragmentDashboardBinding binding;
    private DealerViewModel dealerViewModel;
    private ProgressDialog loading;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        dealerViewModel = ViewModelProviders.of(this).get(DealerViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        init();
        return binding.getRoot();
    }

    private void init() {
        if (PreferenceHelper.getInstance().getString(ConstUtils.USER_NAME, "") != null) {
            binding.textView33.setText("Welcome to Good Auto Deals" + " " +
                    PreferenceHelper.getInstance().getString(ConstUtils.USER_NAME, ""));
        }
        getLoadingStatus();

        if (internet.isNetworkAvailable(getContext())) {
            dealerViewModel.getDealerDashboard();
            getData();
        } else {
            uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_interrnet_connection));
        }


        binding.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivity(getActivity(), AdsManagementActivity.class);
            }
        });
    }

    private void getLoadingStatus() {
        dealerViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
            @Override
            public void onChanged(@Nullable ViewModelStatus viewModelStatus) {
                if (viewModelStatus.isLoadingList) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    public void showLoading() {
        loading = ProgressDialog.show(getContext(), getString(R.string.loading), "", true, false);
    }

    public void hideLoading() {
        loading.cancel();
    }

    private void getData() {
        dealerViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {
                    binding.txtLiveAdsCount.setText(String.valueOf(response.getResp().getDataObject().getLiveAds()));
                    binding.txtPendingCount.setText(String.valueOf(response.getResp().getDataObject().getPendingAds()));
                    binding.txtRejectedCount.setText(String.valueOf(response.getResp().getDataObject().getRejectedAds()));
                    binding.txtSoldCount.setText(String.valueOf(response.getResp().getDataObject().getSoldAds()));
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dealerViewModel.clear();
    }
}