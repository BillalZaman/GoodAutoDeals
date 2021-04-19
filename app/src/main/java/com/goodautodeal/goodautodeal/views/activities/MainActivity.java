package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityMainBinding;
import com.goodautodeal.goodautodeal.fragments.FragmentNavigationDrawer;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.HomeSliderAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;
import com.goodautodeal.goodautodeal.views.models.SliderItem;
import com.goodautodeal.goodautodeal.webview.response.Response;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements FragmentNavigationDrawer.FragmentDrawerListener {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    private ArrayList<AdPremiumsModel> data = new ArrayList<>();
    private ActivityMainBinding binding;
    private FragmentNavigationDrawer fragmentNavigationDrawer;
    private HomeSliderAdapter homeSliderAdapter;
    private PremiumAdapter premiumAdapter;
    private String bannerURL, bannerURL1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);

        init();
    }

    private void init() {
        getLoadingStatus();
        binding.setOnHomeClick(this);
        fragmentNavigationDrawer = (FragmentNavigationDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragmentNavigationDrawer.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        fragmentNavigationDrawer.setDrawerListener(this);
        premiumAdapter = new PremiumAdapter(this);
        displayView(0);

        Log.d("token",PreferenceHelper.getInstance().getAppString(ConstUtils.APIAccessToken,""));
        Log.d("token",ConstUtils.APIAccessToken);

        if (internet.isNetworkAvailable(this)) {
            viewModel.getSliderBanner();
            viewModel.getPremiumAds();
            getData();

        } else {
            uiHelper.showLongToastInCenter(this, getResources().getString(R.string.no_interrnet_connection));

        }
    }

    private void getLoadingStatus() {
        viewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
            @Override
            public void onChanged(@Nullable ViewModelStatus viewModelStatus) {
                if (viewModelStatus.isLoadingList) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    public void showLoading() {
        loading = ProgressDialog.show(this, getString(R.string.loading), "", true, false);
    }

    public void hideLoading() {
        loading.cancel();
    }

    private void setRecyclerView() {
        premiumAdapter = new PremiumAdapter(this);
//        for (int i = 0; i <= 10; i++) {
//            data.add(new PremiumAdsModel(
//                    "BMW 520D M SPORT AUTO", "£900", "2020", "1000cc", "500cc"));
//        }
//        premiumAdapter.setData(data);
        binding.recyclerview.setAdapter(premiumAdapter);
    }

    private void getData() {
        viewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 200 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {
                    if (response.getResp().getDataObject().getSlider() != null) {
                        bannerURL = "https://www.goodautodeals.com" + response.getResp().getDataObject().getSlider().get(0).getImage();
                        bannerURL1 = "https://www.goodautodeals.com" + response.getResp().getDataObject().getSlider().get(1).getImage();
                        Log.d("banner", bannerURL);
                        setupSlider();

                    } else if (response.getResp().getDataObject().getPremimumAds() != null) {
//                    premiumAdapter = new PremiumAdapter(this);

                        data = response.getResp().getDataObject().getPremimumAds();
                        premiumAdapter.setData(data);
                        binding.recyclerview.setAdapter(premiumAdapter);

                    }
                } else {
                    uiHelper.showLongToastInCenter(MainActivity.this, response.getResp().getMessage());
                }
            }
        });
    }

    private void setupSlider() {
        homeSliderAdapter = new HomeSliderAdapter(this);
        binding.imageSlider.setSliderAdapter(homeSliderAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.setAutoCycle(true);
        binding.imageSlider.startAutoCycle();

        binding.imageSlider.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + binding.imageSlider.getCurrentPagePosition());
            }
        });
        renewItems(binding.imageSlider);
    }

    public void renewItems(View view) {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
//            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl(bannerURL);
            } else {
                sliderItem.setImageUrl(bannerURL1);
            }
            sliderItemList.add(sliderItem);
        }
        homeSliderAdapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (homeSliderAdapter.getCount() - 1 >= 0)
            homeSliderAdapter.deleteItem(homeSliderAdapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        homeSliderAdapter.addItem(sliderItem);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        switch (position) {
            case 0: {

                break;
            }
            case 1: {
                // profile
                uiHelper.openActivity(this, ProfileActivity.class);
//                if (PreferenceHelper.getInstance().getString(ConstUtils.isLogin,
//                        "").equalsIgnoreCase(ConstUtils.yes)) {
//                    uiHelper.openActivity(this, ProfileActivity.class);
//                } else {
//                    uiHelper.openActivityAndSendValue(this, WelcomeActivity.class, "user");
//                    binding.drawerLayout.closeDrawer(GravityCompat.START);
//                }
                break;
            }
            case 2: {
                // sell my car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class, "sell my car");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 3: {
                // new car
                uiHelper.openActivityAndSendValue(this, CarViewAdListingActivity.class, "new car");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 4: {
                // used car
                uiHelper.openActivityAndSendValue(this, CarViewAdListingActivity.class, "used car");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 5: {
                // fav
                uiHelper.openActivity(this, FavouriteActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 6: {
                // value your car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class, "value your car");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 7: {
                //dealer list
                uiHelper.openActivity(this, DealersActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 8: {
                //car insurance
                uiHelper.openActivity(this, CarInsuranceActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 9: {
                // car finance
                uiHelper.openActivity(this, CarFinanceActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 10: {
                // change password
                uiHelper.openActivity(this, ChangePasswordActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 11: {
                // FAQ
                uiHelper.openActivity(this, FAQListActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 12: {
                // contact us
                uiHelper.openActivity(this, ContactUsActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 13: {
                // contact us
                uiHelper.showLongToastInCenter(this, "User Logout Successfully");
                PreferenceHelper.getInstance().clearAllPreferences();
                Log.d("logout", PreferenceHelper.getInstance().getAppString(ConstUtils.APIAccessToken,"")
                + ConstUtils.APIAccessToken);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            default: {
                break;
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgMenu: {
                binding.drawerLayout.openDrawer(GravityCompat.START);
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.clear();
    }

}