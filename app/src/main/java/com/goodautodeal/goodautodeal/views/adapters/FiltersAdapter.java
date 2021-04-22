package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListFilterationBinding;
import com.goodautodeal.goodautodeal.views.models.FiltersModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 22/04/21.
 */
public class FiltersAdapter extends RecyclerView.Adapter<FiltersAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FiltersModel> data;

    public FiltersAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<FiltersModel> _data){
        data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListFilterationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_filteration, parent, false);
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
        ItemListFilterationBinding binding;

        public ViewHolder(@NonNull ItemListFilterationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
