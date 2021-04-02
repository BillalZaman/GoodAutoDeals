package com.goodautodeal.goodautodeal.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ProviderHomeDashboardViewholderBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.AdsManagementActivity;
import com.goodautodeal.goodautodeal.views.models.DealerDashboardModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 25/02/21.
 */
public class DealerDashboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<DealerDashboardModel> arrayList;
    Context context;
    int dpSize;
    @Inject
    UIHelper uiHelper;
    int iconWidthdp, iconHeightdp;


    public DealerDashboardAdapter(Context context) {
        this.arrayList = new ArrayList<>();
        this.context = context;
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        dpSize = (int) (16 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        iconWidthdp = (int) (19 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        iconHeightdp = (int) (26 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    public void setData(ArrayList<DealerDashboardModel> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        ProviderHomeDashboardViewholderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.provider_home_dashboard_viewholder, viewGroup, false);
        binding.setAdapter(this);
        return new DashboardViewholder(binding);
    }

    public void onClick(int position) {
        if (position != 0)
            uiHelper.openActivityAndSendValue((Activity) context, AdsManagementActivity.class, arrayList.get(position).getTitle());

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        DashboardViewholder holder = (DashboardViewholder) viewHolder;
        holder.binding.setModel(arrayList.get(position));
        holder.binding.executePendingBindings();
        holder.binding.setPosition(position);

//        Glide.with(context).load(arrayList.get(position).getIcon())
//                .into(holder.binding.imageView22);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DashboardViewholder extends RecyclerView.ViewHolder {
        ProviderHomeDashboardViewholderBinding binding;

        public DashboardViewholder(@NonNull ProviderHomeDashboardViewholderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

