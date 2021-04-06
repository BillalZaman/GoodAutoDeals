package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdConsumptionModel implements Serializable {
    @SerializedName("ExtraUrban")
    @Expose
    private AdExtraUrbanModel adExtraUrbanModel;
    @SerializedName("UrbanCold")
    @Expose
    private AdUrbanColdModel adUrbanColdModel;
    @SerializedName("Combined")
    @Expose
    private AdCombinedModel adCombinedModel;

    public AdExtraUrbanModel getAdExtraUrbanModel() {
        return adExtraUrbanModel;
    }

    public void setAdExtraUrbanModel(AdExtraUrbanModel adExtraUrbanModel) {
        this.adExtraUrbanModel = adExtraUrbanModel;
    }

    public AdUrbanColdModel getAdUrbanColdModel() {
        return adUrbanColdModel;
    }

    public void setAdUrbanColdModel(AdUrbanColdModel adUrbanColdModel) {
        this.adUrbanColdModel = adUrbanColdModel;
    }

    public AdCombinedModel getAdCombinedModel() {
        return adCombinedModel;
    }

    public void setAdCombinedModel(AdCombinedModel adCombinedModel) {
        this.adCombinedModel = adCombinedModel;
    }
}
