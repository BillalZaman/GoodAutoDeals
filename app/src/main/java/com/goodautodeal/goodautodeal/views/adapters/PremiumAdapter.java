package com.goodautodeal.goodautodeal.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.database.DatabaseHelper;
import com.goodautodeal.goodautodeal.database.table.FavouriteModel;
import com.goodautodeal.goodautodeal.databinding.ItemListPremiumadsBinding;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.CarAdDetailActivity;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 18/02/21.
 */
public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.ViewHolder> {
    @Inject
    UIHelper uiHelper;
    int widthdp, heightdp;
    private final Context context;
    private ArrayList<AdPremiumsModel> data;
    private List<FavouriteModel> saveFavouriteAd = new ArrayList<>();
    private FavouriteModel favouriteModel = new FavouriteModel();
    private int selectedPosition = -1;

    public PremiumAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        widthdp = (int) (94 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        heightdp = (int) (69.5 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public void setData(ArrayList<AdPremiumsModel> _data) {
        this.data = _data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListPremiumadsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_premiumads, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.binding.setModel(data.get(position));
        Glide.with(context)
                .load(ConstUtils.BaseURL + data.get(position).getAdimage().get(0).getPath())
                .placeholder(R.drawable.homebanner).apply(new RequestOptions().override(widthdp, heightdp))
                .into(holder.binding.imgAd);

        holder.binding.txtYear.setText(data.get(position).getYear() + " | " + data.get(position).getEngine() +
                " | " + data.get(position).getMileage());

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivityAndSendPosition((Activity) context, CarAdDetailActivity.class, data.get(position).getId());
            }
        });

        if (PreferenceHelper.getInstance().getString(ConstUtils.FAV, "0").equalsIgnoreCase("1")){
            holder.binding.imgHeart.setImageResource(R.drawable.fav);
        }else {
            holder.binding.imgHeart.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }

        holder.binding.imgHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceHelper.getInstance().setString(ConstUtils.FAV,"1");
                holder.binding.imgHeart.setImageResource(R.drawable.fav);
                favouriteModel = new FavouriteModel(data.get(position).getTitle(), data.get(position).getPrice().toString(),
                        data.get(position).getAdimage().get(0).getPath(),
                        data.get(position).getYear()+ " | " + data.get(position).getEngine() + " | " +
                        data.get(position).getMileage());
                saveFavouriteAd.add(favouriteModel);

                DatabaseHelper.getInstance(context).gadDao().insertFavouriteAd(favouriteModel);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListPremiumadsBinding binding;

        public ViewHolder(@NonNull ItemListPremiumadsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
