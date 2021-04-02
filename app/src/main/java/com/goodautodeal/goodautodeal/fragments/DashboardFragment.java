package com.goodautodeal.goodautodeal.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentDashboardBinding;
import com.goodautodeal.goodautodeal.views.adapters.DealerDashboardAdapter;
import com.goodautodeal.goodautodeal.views.models.DealerDashboardModel;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private ArrayList<DealerDashboardModel> data = new ArrayList<>();
    private DealerDashboardAdapter adapter;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new DealerDashboardAdapter(getContext());
        for (int i=0; i<=8; i++){
        data.add(new DealerDashboardModel(20,"Total Jobs",R.drawable.total_jobs));
        }
        adapter.setData(data);
        binding.dashboardList.setAdapter(adapter);
    }
}