package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListDealerMoreBinding;
import com.goodautodeal.goodautodeal.interfaces.DealerMoreInterface;
import com.goodautodeal.goodautodeal.views.models.DealerMoreModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 25/02/21.
 */
public class DealerMoreAdapter extends RecyclerView.Adapter<DealerMoreAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DealerMoreModel> data;
    private DealerMoreInterface dealerMoreInterface;

    public DealerMoreAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        dealerMoreInterface = (DealerMoreInterface) context;
    }

    public void setList(ArrayList<DealerMoreModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDealerMoreBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_dealer_more, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binding.setOnMoreModel(data.get(position));
        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dealerMoreInterface.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListDealerMoreBinding binding;

        public ViewHolder(@NonNull ItemListDealerMoreBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}


