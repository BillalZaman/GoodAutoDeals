package com.goodautodeal.goodautodeal.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.FragmentMoreBinding;
import com.goodautodeal.goodautodeal.views.adapters.DealerMoreAdapter;
import com.goodautodeal.goodautodeal.views.models.DealerMoreModel;

import java.util.ArrayList;


public class MoreFragment extends Fragment {
    private FragmentMoreBinding binding;
    private ArrayList<DealerMoreModel> data = new ArrayList<>();
    private DealerMoreAdapter adapter;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_more, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        adapter = new DealerMoreAdapter(getContext());
//        data.add(new DealerMoreModel(getResources().getString(R.string.sell_my_car)));
        data.add(new DealerMoreModel(getResources().getString(R.string.value_car)));
//        data.add(new DealerMoreModel(getResources().getString(R.string.car_history)));
        data.add(new DealerMoreModel(getResources().getString(R.string.change_pasword)));
//        data.add(new DealerMoreModel(getResources().getString(R.string.faq_s)));
        data.add(new DealerMoreModel(getResources().getString(R.string.contact_us)));
        data.add(new DealerMoreModel(getResources().getString(R.string.logout)));
        adapter.setList(data);
        binding.recyclerView.setAdapter(adapter);
    }
}