package com.goodautodeal.goodautodeal.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListFeatureadBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.CarAdDetailActivity;
import com.goodautodeal.goodautodeal.views.models.AdFeatureModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 16/04/21.
 */

public class AdFeaturedAdapter extends RecyclerView.Adapter<AdFeaturedAdapter.ViewHolder> {
    private final Context context;
    @Inject
    UIHelper uiHelper;
    int widthdp, heightdp;
    private ArrayList<AdFeatureModel> data;

    public AdFeaturedAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    public void setData(ArrayList<AdFeatureModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListFeatureadBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_featuread, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setModel(data.get(position));

        if (data.get(position).getAdimage() != null) {
            Glide.with(context)
                    .load("https://goodautodeals.com" + data.get(position).getAdimage().get(0).getPath())
                    .placeholder(R.drawable.homebanner).into(holder.binding.imgAd);

        }
        holder.binding.txtYear.setText(data.get(position).getYear() + " | " + data.get(position).getEngine() +
                " | " + data.get(position).getMileage());

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivity((Activity) context, CarAdDetailActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListFeatureadBinding binding;

        public ViewHolder(@NonNull ItemListFeatureadBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}

