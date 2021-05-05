package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdTechnicalDetailsModel {

    @SerializedName("General")
    @Expose
    private AdGeneralModel adGeneralModel;
    @SerializedName("Dimensions")
    @Expose
    private AdDimensionsModel adDimensionsModel;
    @SerializedName("Performance")
    @Expose
    private AdPerfomanceModel adPerfomanceModel;
    @SerializedName("Consumption")
    @Expose
    private AdConsumptionModel adConsumptionModel;

    public AdGeneralModel getAdGeneralModel() {
        return adGeneralModel;
    }

    public void setAdGeneralModel(AdGeneralModel adGeneralModel) {
        this.adGeneralModel = adGeneralModel;
    }

    public AdDimensionsModel getAdDimensionsModel() {
        return adDimensionsModel;
    }

    public void setAdDimensionsModel(AdDimensionsModel adDimensionsModel) {
        this.adDimensionsModel = adDimensionsModel;
    }

    public AdPerfomanceModel getAdPerfomanceModel() {
        return adPerfomanceModel;
    }

    public void setAdPerfomanceModel(AdPerfomanceModel adPerfomanceModel) {
        this.adPerfomanceModel = adPerfomanceModel;
    }

    public AdConsumptionModel getAdConsumptionModel() {
        return adConsumptionModel;
    }

    public void setAdConsumptionModel(AdConsumptionModel adConsumptionModel) {
        this.adConsumptionModel = adConsumptionModel;
    }
}
