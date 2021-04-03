package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdEngineModel {
    @SerializedName("FuelCatalyst")
    @Expose
    private String fuelCatalyst;
    @SerializedName("Stroke")
    @Expose
    private Object stroke;
    @SerializedName("PrimaryFuelFlag")
    @Expose
    private Object primaryFuelFlag;
    @SerializedName("ValvesPerCylinder")
    @Expose
    private Integer valvesPerCylinder;
    @SerializedName("Aspiration")
    @Expose
    private String aspiration;
    @SerializedName("FuelSystem")
    @Expose
    private String fuelSystem;
    @SerializedName("NumberOfCylinders")
    @Expose
    private Integer numberOfCylinders;
    @SerializedName("CylinderArrangement")
    @Expose
    private String cylinderArrangement;
    @SerializedName("ValveGear")
    @Expose
    private String valveGear;
    @SerializedName("Location")
    @Expose
    private Object location;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("Bore")
    @Expose
    private Object bore;
    @SerializedName("Make")
    @Expose
    private Object make;
    @SerializedName("FuelDelivery")
    @Expose
    private String fuelDelivery;

    public String getFuelCatalyst() {
        return fuelCatalyst;
    }

    public void setFuelCatalyst(String fuelCatalyst) {
        this.fuelCatalyst = fuelCatalyst;
    }

    public Object getStroke() {
        return stroke;
    }

    public void setStroke(Object stroke) {
        this.stroke = stroke;
    }

    public Object getPrimaryFuelFlag() {
        return primaryFuelFlag;
    }

    public void setPrimaryFuelFlag(Object primaryFuelFlag) {
        this.primaryFuelFlag = primaryFuelFlag;
    }

    public Integer getValvesPerCylinder() {
        return valvesPerCylinder;
    }

    public void setValvesPerCylinder(Integer valvesPerCylinder) {
        this.valvesPerCylinder = valvesPerCylinder;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }

    public String getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem) {
        this.fuelSystem = fuelSystem;
    }

    public Integer getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(Integer numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public String getCylinderArrangement() {
        return cylinderArrangement;
    }

    public void setCylinderArrangement(String cylinderArrangement) {
        this.cylinderArrangement = cylinderArrangement;
    }

    public String getValveGear() {
        return valveGear;
    }

    public void setValveGear(String valveGear) {
        this.valveGear = valveGear;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getBore() {
        return bore;
    }

    public void setBore(Object bore) {
        this.bore = bore;
    }

    public Object getMake() {
        return make;
    }

    public void setMake(Object make) {
        this.make = make;
    }

    public String getFuelDelivery() {
        return fuelDelivery;
    }

    public void setFuelDelivery(String fuelDelivery) {
        this.fuelDelivery = fuelDelivery;
    }

}
