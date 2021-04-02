package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListDealersBinding;
import com.goodautodeal.goodautodeal.views.models.DealersModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class DealerAdapter extends RecyclerView.Adapter<DealerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DealersModel> data;

    public DealerAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<DealersModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDealersBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_dealers, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnModel(data.get(position));
        Glide.with(context)
                .load("https://res-1.cloudinary.com/crunchbase-production/image/upload/c_lpad,f_auto,q_auto:eco/prxyvowygtqllsuvsp2f")
                .into(holder.binding.imgDealer);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListDealersBinding binding;

        public ViewHolder(@NonNull ItemListDealersBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
