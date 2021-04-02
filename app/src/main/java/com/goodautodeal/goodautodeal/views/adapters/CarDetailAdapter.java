package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListCarDetailVrmBinding;
import com.goodautodeal.goodautodeal.views.models.CarDetailModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class CarDetailAdapter extends RecyclerView.Adapter<CarDetailAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CarDetailModel> data;

    public CarDetailAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<CarDetailModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCarDetailVrmBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_car_detail_vrm, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnCarModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListCarDetailVrmBinding binding;

        public ViewHolder(@NonNull ItemListCarDetailVrmBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
