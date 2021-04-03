package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdDataItemsModel {
    @SerializedName("TechnicalDetails")
    @Expose
    private AdTechnicalDetailsModel adTechnicalDetailsModel;
    @SerializedName("VehicleHistory")
    @Expose
    private AdVehicleHistoryModel adVehicleHistoryModel;
    @SerializedName("VehicleRegistration")
    @Expose
    private AdVehicleRegistrationModel adVehicleRegistrationModel;
    @SerializedName("SmmtDetails")
    @Expose
    private AdSmmtDetailsModel adSmmtDetailsModel;

    public AdTechnicalDetailsModel getAdTechnicalDetailsModel() {
        return adTechnicalDetailsModel;
    }

    public void setAdTechnicalDetailsModel(AdTechnicalDetailsModel adTechnicalDetailsModel) {
        this.adTechnicalDetailsModel = adTechnicalDetailsModel;
    }

    public AdVehicleHistoryModel getAdVehicleHistoryModel() {
        return adVehicleHistoryModel;
    }

    public void setAdVehicleHistoryModel(AdVehicleHistoryModel adVehicleHistoryModel) {
        this.adVehicleHistoryModel = adVehicleHistoryModel;
    }

    public AdVehicleRegistrationModel getAdVehicleRegistrationModel() {
        return adVehicleRegistrationModel;
    }

    public void setAdVehicleRegistrationModel(AdVehicleRegistrationModel adVehicleRegistrationModel) {
        this.adVehicleRegistrationModel = adVehicleRegistrationModel;
    }

    public AdSmmtDetailsModel getAdSmmtDetailsModel() {
        return adSmmtDetailsModel;
    }

    public void setAdSmmtDetailsModel(AdSmmtDetailsModel adSmmtDetailsModel) {
        this.adSmmtDetailsModel = adSmmtDetailsModel;
    }
}
