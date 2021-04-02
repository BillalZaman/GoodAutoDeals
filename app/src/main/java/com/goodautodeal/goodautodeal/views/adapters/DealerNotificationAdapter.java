package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListDealerNotificationBinding;
import com.goodautodeal.goodautodeal.views.models.DealerNotificationModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 25/02/21.
 */
public class DealerNotificationAdapter extends RecyclerView.Adapter<DealerNotificationAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DealerNotificationModel> data;

    public DealerNotificationAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setList(ArrayList<DealerNotificationModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDealerNotificationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_dealer_notification, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnNotificationModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListDealerNotificationBinding binding;

        public ViewHolder(@NonNull ItemListDealerNotificationBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}

