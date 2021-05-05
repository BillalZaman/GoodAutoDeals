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
import com.goodautodeal.goodautodeal.databinding.ItemListImageSelectionBinding;
import com.goodautodeal.goodautodeal.interfaces.SubServiceInterface;
import com.goodautodeal.goodautodeal.views.models.UploadImageListModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 05/05/21.
 */
public class AdImagesSelectorAdapter extends RecyclerView.Adapter<AdImagesSelectorAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<UploadImageListModel> data;
//    private String[] data;

    public AdImagesSelectorAdapter(Context context, ArrayList<UploadImageListModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemListImageSelectionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_list_image_selection, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Glide.with(context).load(data.get(position).getImagePath()).
                placeholder(R.drawable.user_profile_demo).into(holder.binding.imgSelectionOne);

        holder.binding.imgSelectionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubServiceInterface positionItemSelection = (SubServiceInterface) context;
                positionItemSelection.subServiceOnClick(position);
            }
        });

    }

    public void setImage(String uri, int position) {
        data.get(position).setImagePath(uri);
        data.get(position).setSelected(true);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemListImageSelectionBinding binding;

        public ViewHolder(@NonNull ItemListImageSelectionBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
