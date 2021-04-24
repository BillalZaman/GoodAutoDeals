package com.goodautodeal.goodautodeal.fragments;

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

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentSoldVehicleBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.DealerAdListViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.GeneralAdViewAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.AdGeneralViewModel;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

public class SoldVehicleFragment extends Fragment {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    DealerAdListViewModel viewModel;
    private ArrayList<AdGeneralViewModel> data = new ArrayList<>();
    private GeneralAdViewAdapter generalAdViewAdapter;
    private FragmentSoldVehicleBinding binding;

    public SoldVehicleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sold_vehicle, container, false);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(DealerAdListViewModel.class);
        init();
        return binding.getRoot();
    }

    private void init() {
        getLoadingStatus();
        generalAdViewAdapter = new GeneralAdViewAdapter(getContext());
        if (internet.isNetworkAvailable(getContext())) {
            viewModel.getSoldAds();
            getDataList();

        } else {
            uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_interrnet_connection));
        }

    }

    private void getDataList() {
        viewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {

                    if (response.getResp().getDataObject().getSoldAdList()!=null) {
                        data = response.getResp().getDataObject().getSoldAdList();
                        generalAdViewAdapter.setData(data);
                        binding.recyclerview.setAdapter(generalAdViewAdapter);

                    } else {
                        uiHelper.showLongToastInCenter(getContext(), "oh now");
                    }
                } else {
                    uiHelper.showLongToastInCenter(getActivity(), response.getResp().getMessage());
                }
            }
        });
    }

    private void getLoadingStatus() {
        viewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clear();
    }
}