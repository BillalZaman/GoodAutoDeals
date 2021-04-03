package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdSmmtDetailsModel {
    @SerializedName("Range")
    @Expose
    private String range;
    @SerializedName("FuelType")
    @Expose
    private String fuelType;
    @SerializedName("EngineCapacity")
    @Expose
    private String engineCapacity;
    @SerializedName("MarketSectorCode")
    @Expose
    private String marketSectorCode;
    @SerializedName("CountryOfOrigin")
    @Expose
    private String countryOfOrigin;
    @SerializedName("ModelCode")
    @Expose
    private String modelCode;
    @SerializedName("ModelVariant")
    @Expose
    private String modelVariant;
    @SerializedName("DataVersionNumber")
    @Expose
    private Object dataVersionNumber;
    @SerializedName("NumberOfGears")
    @Expose
    private Integer numberOfGears;
    @SerializedName("NominalEngineCapacity")
    @Expose
    private Double nominalEngineCapacity;
    @SerializedName("MarqueCode")
    @Expose
    private String marqueCode;
    @SerializedName("Transmission")
    @Expose
    private String transmission;
    @SerializedName("BodyStyle")
    @Expose
    private String bodyStyle;
    @SerializedName("VisibilityDate")
    @Expose
    private String visibilityDate;
    @SerializedName("SysSetupDate")
    @Expose
    private String sysSetupDate;
    @SerializedName("Marque")
    @Expose
    private String marque;
    @SerializedName("CabType")
    @Expose
    private String cabType;
    @SerializedName("TerminateDate")
    @Expose
    private Object terminateDate;
    @SerializedName("Series")
    @Expose
    private String series;
    @SerializedName("NumberOfDoors")
    @Expose
    private Integer numberOfDoors;
    @SerializedName("DriveType")
    @Expose
    private String driveType;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getMarketSectorCode() {
        return marketSectorCode;
    }

    public void setMarketSectorCode(String marketSectorCode) {
        this.marketSectorCode = marketSectorCode;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelVariant() {
        return modelVariant;
    }

    public void setModelVariant(String modelVariant) {
        this.modelVariant = modelVariant;
    }

    public Object getDataVersionNumber() {
        return dataVersionNumber;
    }

    public void setDataVersionNumber(Object dataVersionNumber) {
        this.dataVersionNumber = dataVersionNumber;
    }

    public Integer getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(Integer numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public Double getNominalEngineCapacity() {
        return nominalEngineCapacity;
    }

    public void setNominalEngineCapacity(Double nominalEngineCapacity) {
        this.nominalEngineCapacity = nominalEngineCapacity;
    }

    public String getMarqueCode() {
        return marqueCode;
    }

    public void setMarqueCode(String marqueCode) {
        this.marqueCode = marqueCode;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getVisibilityDate() {
        return visibilityDate;
    }

    public void setVisibilityDate(String visibilityDate) {
        this.visibilityDate = visibilityDate;
    }

    public String getSysSetupDate() {
        return sysSetupDate;
    }

    public void setSysSetupDate(String sysSetupDate) {
        this.sysSetupDate = sysSetupDate;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public Object getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(Object terminateDate) {
        this.terminateDate = terminateDate;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }
}
