package com.goodautodeal.goodautodeal.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentNotificationBinding;
import com.goodautodeal.goodautodeal.views.adapters.DealerNotificationAdapter;
import com.goodautodeal.goodautodeal.views.models.DealerNotificationModel;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {
    private FragmentNotificationBinding binding;
    private ArrayList<DealerNotificationModel> data = new ArrayList<>();
    private DealerNotificationAdapter adapter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_notification, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new DealerNotificationAdapter(getContext());
        for (int i=0; i<=20;i++) {
            data.add(new DealerNotificationModel("Ad Approved",
                    "Dear GoodAutoCar, Your Ad no #1628K9 has been approved by the admin"));
        }
        adapter.setList(data);
        binding.recylcerview.setAdapter(adapter);
    }
}