package com.goodautodeal.goodautodeal.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentProfileBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.DealerViewModel;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.activities.ProfileActivity;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private DealerViewModel dealerViewModel;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        dealerViewModel = ViewModelProviders.of(this).get(DealerViewModel.class);
        init();
        return binding.getRoot();
    }

    private void init() {
        getLoadingStatus();
        if (internet.isNetworkAvailable(getContext())){
            dealerViewModel.getDealerProfile();
            getData();
        } else {
            uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_interrnet_connection));
        }
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
            public void onChanged(@Nullable Response responsee) {
                if (responsee.getResp().getCode() == 1 &&
                        responsee.getResp().getSuccess().equalsIgnoreCase("success")) {

                    if (responsee.getResp().getDataObject().getUserInfo()!=null){

                        binding.setOnProfileModel(responsee.getResp().getDataObject().getUserInfo());
                        Glide.with(getContext()).
                                load("https://www.goodautodeals.com/"+responsee.getResp().getDataObject().getUserInfo().getDealerPersonalModel().getCompanyLogo())
                                .placeholder(R.drawable.user_profile_demo)
                                .into(binding.profileImg);
                    }

                } else {
                    uiHelper.showLongToastInCenter((Activity) getContext(), responsee.getResp().getMessage());
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