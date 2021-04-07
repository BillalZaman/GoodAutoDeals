package com.goodautodeal.goodautodeal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ItemListPackageBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.PaypalInterface;
import com.goodautodeal.goodautodeal.views.models.PackagesModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 29/03/21.
 */
public class PackagesAdapter extends PagerAdapter {
    private final ArrayList<PackagesModel> packagesModels;
    private final Context context;
    @Inject
    UIHelper uiHelper;
    private ItemListPackageBinding binding;
    private final PaypalInterface paypalInterface;

    public PackagesAdapter(ArrayList<PackagesModel> packagesModels, Context context) {
        this.packagesModels = packagesModels;
        this.context = context;
        paypalInterface = (PaypalInterface) context;
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    @Override
    public int getCount() {
        return packagesModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),
                R.layout.item_list_package, container, false);
        binding.setOnPackagesModel(packagesModels.get(position));
        binding.setOnClick(this);
        binding.setPosition(position);
        container.addView(binding.getRoot());

//        binding.btnBuyNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                paypalInterface.buyPackages();
//                uiHelper.openActivity((Activity) context, SellMyCarPartFiveActivity.class);
//            }
//        });

        return binding.getRoot();
    }

    public void onBuyClick(View view, final int position) {
        uiHelper.showLongToastInCenter(context, "" + position);
        if ((position == 0)) {
            paypalInterface.buyPackages("Silver","39.99");
        } else if (position == 1) {
            paypalInterface.buyPackages("Gold","59.99");
        } else if (position == 2) {
            paypalInterface.buyPackages("Diamond","69.99");
        } else if (position == 3) {
            paypalInterface.buyPackages("Platinum","89.99");
        }
    }
}
