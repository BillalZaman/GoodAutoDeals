package com.goodautodeal.goodautodeal.views.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
@Entity(tableName = "AdSmmtDetail_table")
public class AdSmmtDetailsModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "range")
    @SerializedName("Range")
    @Expose
    private String range;

    @ColumnInfo(name = "marque")
    @SerializedName("Marque")
    @Expose
    private String marque;

    @ColumnInfo(name = "fuelType")
    @SerializedName("FuelType")
    @Expose
    private String fuelType;

    @ColumnInfo(name = "engineCapacity")
    @SerializedName("EngineCapacity")
    @Expose
    private String engineCapacity;

    @ColumnInfo(name = "modelVariant")
    @SerializedName("ModelVariant")
    @Expose
    private String modelVariant;

    @ColumnInfo(name = "noOfGears")
    @SerializedName("NumberOfGears")
    @Expose
    private Integer numberOfGears;

    @ColumnInfo(name = "nominalEngine")
    @SerializedName("NominalEngineCapacity")
    @Expose
    private Double nominalEngineCapacity;

    @ColumnInfo(name = "transmission")
    @SerializedName("Transmission")
    @Expose
    private String transmission;

    @ColumnInfo(name = "bodyStyle")
    @SerializedName("BodyStyle")
    @Expose
    private String bodyStyle;

    @ColumnInfo(name = "noOfDoors")
    @SerializedName("NumberOfDoors")
    @Expose
    private Integer numberOfDoors;

    public AdSmmtDetailsModel(String range, String marque, String fuelType, String engineCapacity, String modelVariant,
                              Integer numberOfGears, Double nominalEngineCapacity, String transmission, String bodyStyle,
                              Integer numberOfDoors) {
        this.range = range;
        this.marque = marque;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.modelVariant = modelVariant;
        this.numberOfGears = numberOfGears;
        this.nominalEngineCapacity = nominalEngineCapacity;
        this.transmission = transmission;
        this.bodyStyle = bodyStyle;
        this.numberOfDoors = numberOfDoors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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

    public String getModelVariant() {
        return modelVariant;
    }

    public void setModelVariant(String modelVariant) {
        this.modelVariant = modelVariant;
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

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
