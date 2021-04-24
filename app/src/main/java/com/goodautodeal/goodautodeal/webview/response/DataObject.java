package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.AdDetailModel;
import com.goodautodeal.goodautodeal.views.models.AdFeatureModel;
import com.goodautodeal.goodautodeal.views.models.AdGeneralViewModel;
import com.goodautodeal.goodautodeal.views.models.AdPremiumsModel;
import com.goodautodeal.goodautodeal.views.models.DealerPersonalModel;
import com.goodautodeal.goodautodeal.views.models.DealersModel;
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
    @SerializedName("verify")
    @Expose
    private int verify;
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
    @SerializedName("DealersList")
    @Expose
    private ArrayList<DealerPersonalModel> dealersModels = null;
    @SerializedName("AdDetail")
    @Expose
    private AdDetailModel adDetailModels;
    @SerializedName("DataItems")
    @Expose
    private ValueYourCarModel valueYourCarModel;
    @SerializedName("liveAds")
    @Expose
    private Integer liveAds;
    @SerializedName("pendingAds")
    @Expose
    private Integer pendingAds;
    @SerializedName("soldAds")
    @Expose
    private Integer soldAds;
    @SerializedName("rejectedAds")
    @Expose
    private Integer rejectedAds;
    @SerializedName("totalAds")
    @Expose
    private Integer totalAds;
    @SerializedName("PublisedAdsList")
    @Expose
    private ArrayList<AdGeneralViewModel> publishedAdList = null;
    @SerializedName("PendingAdsList")
    @Expose
    private ArrayList<AdGeneralViewModel> pendingAdList = null;
    @SerializedName("RejectedAdsList")
    @Expose
    private ArrayList<AdGeneralViewModel> rejectedAdList = null;
    @SerializedName("SoldAdsList")
    @Expose
    private ArrayList<AdGeneralViewModel> soldAdList = null;
    @SerializedName("DraftAdsList")
    @Expose
    private ArrayList<AdGeneralViewModel> draftAdList = null;

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

    public ArrayList<DealerPersonalModel> getDealersModels() {
        return dealersModels;
    }

    public void setDealersModels(ArrayList<DealerPersonalModel> dealersModels) {
        this.dealersModels = dealersModels;
    }

    public AdDetailModel getAdDetailModels() {
        return adDetailModels;
    }

    public void setAdDetailModels(AdDetailModel adDetailModels) {
        this.adDetailModels = adDetailModels;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public Integer getLiveAds() {
        return liveAds;
    }

    public void setLiveAds(Integer liveAds) {
        this.liveAds = liveAds;
    }

    public Integer getPendingAds() {
        return pendingAds;
    }

    public void setPendingAds(Integer pendingAds) {
        this.pendingAds = pendingAds;
    }

    public Integer getSoldAds() {
        return soldAds;
    }

    public void setSoldAds(Integer soldAds) {
        this.soldAds = soldAds;
    }

    public Integer getRejectedAds() {
        return rejectedAds;
    }

    public void setRejectedAds(Integer rejectedAds) {
        this.rejectedAds = rejectedAds;
    }

    public Integer getTotalAds() {
        return totalAds;
    }

    public void setTotalAds(Integer totalAds) {
        this.totalAds = totalAds;
    }

    public ArrayList<AdGeneralViewModel> getPublishedAdList() {
        return publishedAdList;
    }

    public void setPublishedAdList(ArrayList<AdGeneralViewModel> publishedAdList) {
        this.publishedAdList = publishedAdList;
    }

    public ArrayList<AdGeneralViewModel> getPendingAdList() {
        return pendingAdList;
    }

    public void setPendingAdList(ArrayList<AdGeneralViewModel> pendingAdList) {
        this.pendingAdList = pendingAdList;
    }

    public ArrayList<AdGeneralViewModel> getRejectedAdList() {
        return rejectedAdList;
    }

    public void setRejectedAdList(ArrayList<AdGeneralViewModel> rejectedAdList) {
        this.rejectedAdList = rejectedAdList;
    }

    public ArrayList<AdGeneralViewModel> getSoldAdList() {
        return soldAdList;
    }

    public void setSoldAdList(ArrayList<AdGeneralViewModel> soldAdList) {
        this.soldAdList = soldAdList;
    }

    public ArrayList<AdGeneralViewModel> getDraftAdList() {
        return draftAdList;
    }

    public void setDraftAdList(ArrayList<AdGeneralViewModel> draftAdList) {
        this.draftAdList = draftAdList;
    }
}
