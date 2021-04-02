package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListCarFeaturesBinding;
import com.goodautodeal.goodautodeal.views.models.AccessoriesModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 19/02/21.
 */
public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AccessoriesModel> data;

    public AccessoriesAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<AccessoriesModel> __data){
        this.data = __data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCarFeaturesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_car_features, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListCarFeaturesBinding binding;
        public ViewHolder(@NonNull ItemListCarFeaturesBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
