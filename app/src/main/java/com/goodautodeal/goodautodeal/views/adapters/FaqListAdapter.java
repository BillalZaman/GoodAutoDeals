package com.goodautodeal.goodautodeal.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListFaqListBinding;
import com.goodautodeal.goodautodeal.views.activities.FAQDetailActivity;
import com.goodautodeal.goodautodeal.views.models.FaqListModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 20/02/21.
 */
public class FaqListAdapter extends RecyclerView.Adapter<FaqListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FaqListModel> data;

    public FaqListAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setList(ArrayList<FaqListModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListFaqListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_faq_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnModel(data.get(position));
        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Activity) context, FAQDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListFaqListBinding binding;

        public ViewHolder(@NonNull ItemListFaqListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
