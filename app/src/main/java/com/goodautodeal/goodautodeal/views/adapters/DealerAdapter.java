package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ItemListDealersBinding;
import com.goodautodeal.goodautodeal.views.models.DealerPersonalModel;
import com.goodautodeal.goodautodeal.views.models.DealersModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class DealerAdapter extends RecyclerView.Adapter<DealerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DealerPersonalModel> data;

    public DealerAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<DealerPersonalModel> data) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.binding.setOnDealerModel(data.get(position));
        holder.binding.setOnModel(data.get(position).getDealer());
        holder.binding.dealerDesc.setText(Html.fromHtml(data.get(position).getDealer().getDescription()).toString());
        Glide.with(context)
                .load(ConstUtils.BaseURL+data.get(position).getDealer().getCompanyLogo())
                .into(holder.binding.imgDealer);

        data.get(position).setExpendable(false);
        holder.binding.dealerDesc.setPaintFlags(holder.binding.dealerDesc.getPaintFlags());
        holder.binding.txtReadMore.setPaintFlags(holder.binding.dealerDesc.getPaintFlags());
        holder.binding.txtShowLess.setPaintFlags(holder.binding.dealerDesc.getPaintFlags());

        holder.binding.dealerDesc.getViewTreeObserver().addOnPreDrawListener(() -> {

            int lineCount = holder.binding.dealerDesc.getLayout().getLineCount();

            Log.d("myNameBilal", "onPreDraw: " + position + " : " + lineCount);

            if (lineCount > 3) {
                holder.binding.txtReadMore.setVisibility(View.VISIBLE);
            } else {
                holder.binding.txtReadMore.setVisibility(View.GONE);
            }
            return true;
        });

        holder.binding.txtReadMore.setOnClickListener(view -> {
            if (data.get(position).getExpendable()) {
                data.get(position).setExpendable(false);
                holder.binding.dealerDesc.setMaxLines(10);
                holder.binding.txtReadMore.setText(R.string.read_less);
            } else {
                data.get(position).setExpendable(true);
                holder.binding.dealerDesc.setMaxLines(3);
                holder.binding.txtReadMore.setText(R.string.read_more);
            }
        });
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
