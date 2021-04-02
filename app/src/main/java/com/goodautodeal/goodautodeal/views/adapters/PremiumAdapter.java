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
import com.goodautodeal.goodautodeal.databinding.ItemListPremiumadsBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.CarAdDetailActivity;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 18/02/21.
 */
public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PremiumAdsModel> data;
    @Inject
    UIHelper uiHelper;

    public PremiumAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    public void setData(ArrayList<PremiumAdsModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListPremiumadsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_premiumads, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setModel(data.get(position));
        Glide.with(context)
                .load("https://m.atcdn.co.uk/ect/media/w1920/brand-store/audi/hero.jpg")
                .placeholder(R.drawable.homebanner).into(holder.binding.imgAd);

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
        ItemListPremiumadsBinding binding;

        public ViewHolder(@NonNull ItemListPremiumadsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
