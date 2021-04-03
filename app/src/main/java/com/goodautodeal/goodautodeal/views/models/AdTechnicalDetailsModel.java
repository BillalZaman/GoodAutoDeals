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
}
