package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListAdImageCrousalBinding;
import com.goodautodeal.goodautodeal.views.models.AdImageCrousalModel;
import com.goodautodeal.goodautodeal.views.models.AdImagesModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 19/05/21.
 */
public class AdImageCarouselAdapter extends RecyclerView.Adapter<AdImageCarouselAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AdImagesModel> data = new ArrayList<>();

    public AdImageCarouselAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<AdImagesModel> _data){
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListAdImageCrousalBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context.getApplicationContext()),
                R.layout.item_list_ad_image_crousal, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getPath()).into(holder.binding.carImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListAdImageCrousalBinding binding;

        public ViewHolder(@NonNull ItemListAdImageCrousalBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
