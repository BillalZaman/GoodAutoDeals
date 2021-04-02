package com.goodautodeal.goodautodeal.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentPendingBinding;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;


public class PendingFragment extends Fragment {
    private ArrayList<PremiumAdsModel> data = new ArrayList<>();
    private PremiumAdapter premiumAdapter;
    private FragmentPendingBinding binding;

    public PendingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pending, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        premiumAdapter = new PremiumAdapter(getContext());
        for (int i=0; i<=10; i++){
            data.add(new PremiumAdsModel("BMW 520D M SPORT AUTO", "£900", "2020","1000cc", "500cc"));
        }
        premiumAdapter.setData(data);
        binding.recyclerview.setAdapter(premiumAdapter);
    }
}