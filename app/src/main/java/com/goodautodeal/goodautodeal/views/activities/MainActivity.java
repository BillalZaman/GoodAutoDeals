package com.goodautodeal.goodautodeal.views.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityMainBinding;
import com.goodautodeal.goodautodeal.fragments.FragmentNavigationDrawer;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.adapters.HomeSliderAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;
import com.goodautodeal.goodautodeal.views.models.PremiumAdsModel;
import com.goodautodeal.goodautodeal.views.models.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements FragmentNavigationDrawer.FragmentDrawerListener {
    private ActivityMainBinding binding;
    private FragmentNavigationDrawer fragmentNavigationDrawer;
    private HomeSliderAdapter homeSliderAdapter;
    private ArrayList<PremiumAdsModel> data = new ArrayList<>();
    private PremiumAdapter premiumAdapter;
    @Inject
    UIHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        setupSlider();
        binding.setOnHomeClick(this);
        fragmentNavigationDrawer = (FragmentNavigationDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragmentNavigationDrawer.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        fragmentNavigationDrawer.setDrawerListener(this);

        displayView(0);
        setRecyclerView();
    }

    private void setRecyclerView() {
        premiumAdapter = new PremiumAdapter(this);
        for (int i=0; i<=10; i++){
            data.add(new PremiumAdsModel("BMW 520D M SPORT AUTO", "£900", "2020","1000cc", "500cc"));
        }
        premiumAdapter.setData(data);
        binding.recyclerview.setAdapter(premiumAdapter);
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
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://m.atcdn.co.uk/ect/media/w1920/brand-store/audi/hero.jpg?auto=compress&cs=tinysrgb&h=1000&w=1260");
            } else {
                sliderItem.setImageUrl("https://www.driving.co.uk/s3/st-driving-prod/uploads/2019/03/2019-Volkswagen-T-Roc-R-Line-01.jpg?auto=compress&cs=tinysrgb&h=1000&w=1260");
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
                uiHelper.openActivityAndSendValue(this, WelcomeActivity.class,"user");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
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
                uiHelper.openActivityAndSendValue(this, CarViewAdListingActivity.class,"used car");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 5:{
                // fav
                uiHelper.openActivity(this, FavouriteActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 6: {
                // value your car
                uiHelper.openActivityAndSendValue(this, SellMyCarPartOneActivity.class,"value your car");
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
            case 10:{
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
}