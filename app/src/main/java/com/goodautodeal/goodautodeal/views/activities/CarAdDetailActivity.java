package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityCarAdDetailBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.UserViewModel;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.adapters.CarDetailAdapter;
import com.goodautodeal.goodautodeal.views.adapters.HomeSliderAdapter;
import com.goodautodeal.goodautodeal.views.models.CarDetailModel;
import com.goodautodeal.goodautodeal.views.models.SliderItem;
import com.goodautodeal.goodautodeal.webview.response.Response;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarAdDetailActivity extends AppCompatActivity {
    private final ArrayList<CarDetailModel> dataCarDetailVRM = new ArrayList<>();
    @Inject
    Internet internet;
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private ActivityCarAdDetailBinding binding;
    private HomeSliderAdapter homeSliderAdapter;
    private CarDetailAdapter adapterCarDetailVRM;
    private String isActivityName;
    private UserViewModel adPostingViewModel;
    private String website, videoLink;
    private int adno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_car_ad_detail);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        adPostingViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        init();
    }

    private void init() {
//        setupSlider();
        getLoadingStatus();
        binding.setActivity(this);
        adno = getIntent().getIntExtra(ConstUtils.CLASS_NAME,0);

        isActivityName = "5";
        Log.d("id:" ,""+ isActivityName);
        if (adno != 0) {
            if (internet.isNetworkAvailable(this)) {
                adPostingViewModel.getAdDetail(""+adno);
                getData();
            } else {
                uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
            }
        }
//        recyclerviewCarDetailVRM();
    }

    private void getLoadingStatus() {
        adPostingViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
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

    private void getData() {
        adPostingViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {

                if (response.getResp().getCode() == 1 && response.getResp().getSuccess().equalsIgnoreCase("Success")) {

                    if (response.getResp().getDataObject().getAdDetailModels()!=null){
//                        binding.setOnAddetailModel(response.getResp().getDataObject().getAdDetailModels());
                        binding.setOnAddetailModel(response.getResp().getDataObject().getAdDetailModels());
                        binding.setOnAdUserModel(response.getResp().getDataObject().getAdDetailModels().getUsers());
                        binding.setOnAdDealerModel(response.getResp().getDataObject().getAdDetailModels().getDealer());

                        Glide.with(CarAdDetailActivity.this).load(ConstUtils.BaseURL +
                                response.getResp().getDataObject().getAdDetailModels().getAdimage().get(0).getPath()).into(binding.carImage);

                        Glide.with(CarAdDetailActivity.this).load(ConstUtils.BaseURL +
                                response.getResp().getDataObject().getAdDetailModels().getDealer().getCompanyLogo())
                                .placeholder(R.drawable.user_profile_demo).into(binding.imgDealer);
                        website = response.getResp().getDataObject().getAdDetailModels().getDealer().getWebsite();
//                        videoLink = response.getResp().getDataObject().getAdDetailModels().getAdVideoModel().getVideoId();

                        binding.txtDescrption.setText(
                                android.text.Html.fromHtml(
                                        response.getResp().getDataObject().getAdDetailModels().getDescription(),
                                        HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
                        );

                        if (response.getResp().getDataObject().getAdDetailModels().getFeatures()!=null){

                        }

                    } else {
                        uiHelper.showLongToastInCenter(CarAdDetailActivity.this, "hi else");
                    }


                } else {
                    uiHelper.showLongToastInCenter(CarAdDetailActivity.this, "getMessage()");
                }
            }
        });
    }

//    private void recyclerviewCarDetailVRM() {
//        adapterCarDetailVRM = new CarDetailAdapter(this);
//        for (int i = 0; i <= 8; i++) {
//            dataCarDetailVRM.add(new CarDetailModel("Engine", "2.0 L"));
//        }
//        adapterCarDetailVRM.setData(dataCarDetailVRM);
//
//        binding.recyclerComfort.setAdapter(adapterCarDetailVRM);
//        binding.recyclerSpecific.setAdapter(adapterCarDetailVRM);
//    }

//    private void setupSlider() {
//        homeSliderAdapter = new HomeSliderAdapter(this);
//        binding.imageSlider.setSliderAdapter(homeSliderAdapter);
//        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
//        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
//        binding.imageSlider.setScrollTimeInSec(3);
//        binding.imageSlider.setAutoCycle(true);
//        binding.imageSlider.startAutoCycle();
//
//        binding.imageSlider.setOnIndicatorClickListener(new DrawController.ClickListener() {
//            @Override
//            public void onIndicatorClicked(int position) {
//                Log.i("GGG", "onIndicatorClicked: " + binding.imageSlider.getCurrentPagePosition());
//            }
//        });
//        renewItems(binding.imageSlider);
//    }
//
//    public void renewItems(View view) {
//        List<SliderItem> sliderItemList = new ArrayList<>();
//        //dummy data
//        for (int i = 0; i < 5; i++) {
//            SliderItem sliderItem = new SliderItem();
//            sliderItem.setDescription("Slider Item " + i);
//            if (i % 2 == 0) {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            } else {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
//            }
//            sliderItemList.add(sliderItem);
//        }
//        homeSliderAdapter.renewItems(sliderItemList);
//    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnPublishedNow: {

                break;
            }
            case R.id.btn_pending: {

                break;
            }
            case R.id.btn_rejected: {

                break;
            }
            case R.id.txtWebsite:{
//                String url = "http://www.stackoverflow.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(website));
                startActivity(i);
                break;
            }
            case R.id.imageView6:{
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://youtu.be/"+videoLink)));
                break;
            }
        }
    }
}