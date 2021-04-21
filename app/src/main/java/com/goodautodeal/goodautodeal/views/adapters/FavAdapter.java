package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.database.table.FavouriteModel;
import com.goodautodeal.goodautodeal.databinding.FavItemBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 21/04/21.
 */
public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private final Context context;
    @Inject
    UIHelper uiHelper;
    private List<FavouriteModel> saveFavouriteAd = new ArrayList<>();

    public FavAdapter(Context context) {
        this.context = context;
        this.saveFavouriteAd = new ArrayList<>();
//        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    public void setData(ArrayList<FavouriteModel> _data) {
        this.saveFavouriteAd = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.fav_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binding.setModel(saveFavouriteAd.get(position));
        Glide.with(context)
                .load("https://goodautodeals.com" + saveFavouriteAd.get(position).getAdImage())
                .placeholder(R.drawable.homebanner).into(holder.binding.imgAd);

    }

    @Override
    public int getItemCount() {
        return saveFavouriteAd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FavItemBinding binding;

        public ViewHolder(@NonNull FavItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
