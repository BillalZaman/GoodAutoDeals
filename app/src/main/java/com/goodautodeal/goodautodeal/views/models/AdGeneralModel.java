package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdGeneralModel {
    @SerializedName("Engine")
    @Expose
    private AdEngineModel engine;
    @SerializedName("PowerDelivery")
    @Expose
    private Object powerDelivery;
    @SerializedName("TypeApprovalCategory")
    @Expose
    private Object typeApprovalCategory;
//    @SerializedName("ElectricVehicleBattery")
//    @Expose
//    private ElectricVehicleBattery electricVehicleBattery;
    @SerializedName("SeriesDescription")
    @Expose
    private String seriesDescription;
    @SerializedName("DriverPosition")
    @Expose
    private String driverPosition;
    @SerializedName("DrivingAxle")
    @Expose
    private String drivingAxle;
    @SerializedName("DataVersionNumber")
    @Expose
    private Object dataVersionNumber;
    @SerializedName("EuroStatus")
    @Expose
    private String euroStatus;
    @SerializedName("IsLimitedEdition")
    @Expose
    private Object isLimitedEdition;

    public AdEngineModel getEngine() {
        return engine;
    }

    public void setEngine(AdEngineModel engine) {
        this.engine = engine;
    }

    public Object getPowerDelivery() {
        return powerDelivery;
    }

    public void setPowerDelivery(Object powerDelivery) {
        this.powerDelivery = powerDelivery;
    }

    public Object getTypeApprovalCategory() {
        return typeApprovalCategory;
    }

    public void setTypeApprovalCategory(Object typeApprovalCategory) {
        this.typeApprovalCategory = typeApprovalCategory;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public String getDriverPosition() {
        return driverPosition;
    }

    public void setDriverPosition(String driverPosition) {
        this.driverPosition = driverPosition;
    }

    public String getDrivingAxle() {
        return drivingAxle;
    }

    public void setDrivingAxle(String drivingAxle) {
        this.drivingAxle = drivingAxle;
    }

    public Object getDataVersionNumber() {
        return dataVersionNumber;
    }

    public void setDataVersionNumber(Object dataVersionNumber) {
        this.dataVersionNumber = dataVersionNumber;
    }

    public String getEuroStatus() {
        return euroStatus;
    }

    public void setEuroStatus(String euroStatus) {
        this.euroStatus = euroStatus;
    }

    public Object getIsLimitedEdition() {
        return isLimitedEdition;
    }

    public void setIsLimitedEdition(Object isLimitedEdition) {
        this.isLimitedEdition = isLimitedEdition;
    }
}
