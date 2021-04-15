package com.goodautodeal.goodautodeal.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListPremiumadsBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.CarAdDetailActivity;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 18/02/21.
 */
public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AdPremiumsModel> data;
    @Inject
    UIHelper uiHelper;
    int widthdp, heightdp;

    public PremiumAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    public void setData(ArrayList<AdPremiumsModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
        widthdp = (int) (94 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        heightdp = (int) (69.5 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
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
                .load("https://goodautodeals.com"+data.get(position).getAdimage().get(0).getPath())
                .placeholder(R.drawable.homebanner).apply(new RequestOptions().override(widthdp, heightdp))
            .into(holder.binding.imgAd);

        holder.binding.txtYear.setText(data.get(position).getYear() + " | " + data.get(position).getEngine() +
                " | " +  data.get(position).getMileage());
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
