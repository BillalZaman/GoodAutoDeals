package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdDimensionsModel {
    @SerializedName("UnladenWeight")
    @Expose
    private Integer unladenWeight;
    @SerializedName("RigidArtic")
    @Expose
    private Object rigidArtic;
    @SerializedName("BodyShape")
    @Expose
    private Object bodyShape;
    @SerializedName("PayloadVolume")
    @Expose
    private Object payloadVolume;
    @SerializedName("PayloadWeight")
    @Expose
    private Object payloadWeight;
    @SerializedName("Height")
    @Expose
    private Integer height;
    @SerializedName("NumberOfDoors")
    @Expose
    private Integer numberOfDoors;
    @SerializedName("NumberOfSeats")
    @Expose
    private Object numberOfSeats;
    @SerializedName("KerbWeight")
    @Expose
    private Integer kerbWeight;
    @SerializedName("GrossTrainWeight")
    @Expose
    private Integer grossTrainWeight;
    @SerializedName("FuelTankCapacity")
    @Expose
    private Integer fuelTankCapacity;
    @SerializedName("LoadLength")
    @Expose
    private Object loadLength;
    @SerializedName("DataVersionNumber")
    @Expose
    private Object dataVersionNumber;
    @SerializedName("WheelBase")
    @Expose
    private Integer wheelBase;
    @SerializedName("CarLength")
    @Expose
    private Integer carLength;
    @SerializedName("Width")
    @Expose
    private Integer width;
    @SerializedName("NumberOfAxles")
    @Expose
    private Integer numberOfAxles;
    @SerializedName("GrossVehicleWeight")
    @Expose
    private Integer grossVehicleWeight;
    @SerializedName("GrossCombinedWeight")
    @Expose
    private Integer grossCombinedWeight;

    public Integer getUnladenWeight() {
        return unladenWeight;
    }

    public void setUnladenWeight(Integer unladenWeight) {
        this.unladenWeight = unladenWeight;
    }

    public Object getRigidArtic() {
        return rigidArtic;
    }

    public void setRigidArtic(Object rigidArtic) {
        this.rigidArtic = rigidArtic;
    }

    public Object getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(Object bodyShape) {
        this.bodyShape = bodyShape;
    }

    public Object getPayloadVolume() {
        return payloadVolume;
    }

    public void setPayloadVolume(Object payloadVolume) {
        this.payloadVolume = payloadVolume;
    }

    public Object getPayloadWeight() {
        return payloadWeight;
    }

    public void setPayloadWeight(Object payloadWeight) {
        this.payloadWeight = payloadWeight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Object getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Object numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getKerbWeight() {
        return kerbWeight;
    }

    public void setKerbWeight(Integer kerbWeight) {
        this.kerbWeight = kerbWeight;
    }

    public Integer getGrossTrainWeight() {
        return grossTrainWeight;
    }

    public void setGrossTrainWeight(Integer grossTrainWeight) {
        this.grossTrainWeight = grossTrainWeight;
    }

    public Integer getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(Integer fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public Object getLoadLength() {
        return loadLength;
    }

    public void setLoadLength(Object loadLength) {
        this.loadLength = loadLength;
    }

    public Object getDataVersionNumber() {
        return dataVersionNumber;
    }

    public void setDataVersionNumber(Object dataVersionNumber) {
        this.dataVersionNumber = dataVersionNumber;
    }

    public Integer getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(Integer wheelBase) {
        this.wheelBase = wheelBase;
    }

    public Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(Integer numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public Integer getGrossVehicleWeight() {
        return grossVehicleWeight;
    }

    public void setGrossVehicleWeight(Integer grossVehicleWeight) {
        this.grossVehicleWeight = grossVehicleWeight;
    }

    public Integer getGrossCombinedWeight() {
        return grossCombinedWeight;
    }

    public void setGrossCombinedWeight(Integer grossCombinedWeight) {
        this.grossCombinedWeight = grossCombinedWeight;
    }

}
