package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.AdFeatureModel;
import com.goodautodeal.goodautodeal.views.models.AdGeneralViewModel;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;
import com.goodautodeal.goodautodeal.views.models.SliderModel;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.views.models.ValueYourCarModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class DataObject implements Serializable {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;
    @SerializedName("UserInfo")
    @Expose
    private UserInfoModel userInfo;
    @SerializedName("Slider")
    @Expose
    private List<SliderModel> slider = null;
    @SerializedName("PremimumAds")
    @Expose
    private ArrayList<AdPremiumsModel> premimumAds = null;
    @SerializedName("AdPosts")
    @Expose
    private ArrayList<AdGeneralViewModel> newCarAds = null;
    @SerializedName("FeaturedAd")
    @Expose
    private ArrayList<AdFeatureModel> featureAd = null;
    @SerializedName("DataItems")
    @Expose
    private ValueYourCarModel valueYourCarModel;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public UserInfoModel getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoModel userInfo) {
        this.userInfo = userInfo;
    }

    public ValueYourCarModel getValueYourCarModel() {
        return valueYourCarModel;
    }

    public void setValueYourCarModel(ValueYourCarModel valueYourCarModel) {
        this.valueYourCarModel = valueYourCarModel;
    }

    public List<SliderModel> getSlider() {
        return slider;
    }

    public void setSlider(List<SliderModel> slider) {
        this.slider = slider;
    }

    public ArrayList<AdPremiumsModel> getPremimumAds() {
        return premimumAds;
    }

    public void setPremimumAds(ArrayList<AdPremiumsModel> premimumAds) {
        this.premimumAds = premimumAds;
    }

    public ArrayList<AdGeneralViewModel> getNewCarAds() {
        return newCarAds;
    }

    public void setNewCarAds(ArrayList<AdGeneralViewModel> newCarAds) {
        this.newCarAds = newCarAds;
    }

    public ArrayList<AdFeatureModel> getFeatureAd() {
        return featureAd;
    }

    public void setFeatureAd(ArrayList<AdFeatureModel> featureAd) {
        this.featureAd = featureAd;
    }
}
