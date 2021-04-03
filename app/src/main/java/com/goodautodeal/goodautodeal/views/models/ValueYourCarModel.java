package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 02/04/21.
 */
public class ValueYourCarModel implements Serializable {
    @SerializedName("Vrm")
    @Expose
    private String vrm;
    @SerializedName("Mileage")
    @Expose
    private String mileage;
    @SerializedName("PlateYear")
    @Expose
    private String plateYear;
    @SerializedName("ValuationList")
    @Expose
    private ValuationListModel valuationList;
    @SerializedName("ValuationTime")
    @Expose
    private String valuationTime;
    @SerializedName("VehicleDescription")
    @Expose
    private String vehicleDescription;
    @SerializedName("ValuationBook")
    @Expose
    private String valuationBook;
    @SerializedName("ExtractNumber")
    @Expose
    private Integer extractNumber;

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


    public String getVrm() {
        return vrm;
    }

    public void setVrm(String vrm) {
        this.vrm = vrm;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPlateYear() {
        return plateYear;
    }

    public void setPlateYear(String plateYear) {
        this.plateYear = plateYear;
    }

    public ValuationListModel getValuationList() {
        return valuationList;
    }

    public void setValuationList(ValuationListModel valuationList) {
        this.valuationList = valuationList;
    }

    public String getValuationTime() {
        return valuationTime;
    }

    public void setValuationTime(String valuationTime) {
        this.valuationTime = valuationTime;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public String getValuationBook() {
        return valuationBook;
    }

    public void setValuationBook(String valuationBook) {
        this.valuationBook = valuationBook;
    }

    public Integer getExtractNumber() {
        return extractNumber;
    }

    public void setExtractNumber(Integer extractNumber) {
        this.extractNumber = extractNumber;
    }

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
