package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdVehicleHistoryModel {
    @SerializedName("V5CCertificateCount")
    @Expose
    private Integer v5CCertificateCount;
    @SerializedName("PlateChangeCount")
    @Expose
    private Integer plateChangeCount;
    @SerializedName("NumberOfPreviousKeepers")
    @Expose
    private Integer numberOfPreviousKeepers;
//    @SerializedName("V5CCertificateList")
//    @Expose
//    private List<V5CCertificate> v5CCertificateList = null;
    @SerializedName("KeeperChangesCount")
    @Expose
    private Integer keeperChangesCount;
    @SerializedName("VicCount")
    @Expose
    private Integer vicCount;
    @SerializedName("ColourChangeCount")
    @Expose
    private Object colourChangeCount;
    @SerializedName("ColourChangeList")
    @Expose
    private Object colourChangeList;
//    @SerializedName("KeeperChangesList")
//    @Expose
//    private List<KeeperChanges> keeperChangesList = null;
//    @SerializedName("PlateChangeList")
//    @Expose
//    private List<PlateChange> plateChangeList = null;
    @SerializedName("VicList")
    @Expose
    private Object vicList;

    public Integer getV5CCertificateCount() {
        return v5CCertificateCount;
    }

    public void setV5CCertificateCount(Integer v5CCertificateCount) {
        this.v5CCertificateCount = v5CCertificateCount;
    }

    public Integer getPlateChangeCount() {
        return plateChangeCount;
    }

    public void setPlateChangeCount(Integer plateChangeCount) {
        this.plateChangeCount = plateChangeCount;
    }

    public Integer getNumberOfPreviousKeepers() {
        return numberOfPreviousKeepers;
    }

    public void setNumberOfPreviousKeepers(Integer numberOfPreviousKeepers) {
        this.numberOfPreviousKeepers = numberOfPreviousKeepers;
    }

    public Integer getKeeperChangesCount() {
        return keeperChangesCount;
    }

    public void setKeeperChangesCount(Integer keeperChangesCount) {
        this.keeperChangesCount = keeperChangesCount;
    }

    public Integer getVicCount() {
        return vicCount;
    }

    public void setVicCount(Integer vicCount) {
        this.vicCount = vicCount;
    }

    public Object getColourChangeCount() {
        return colourChangeCount;
    }

    public void setColourChangeCount(Object colourChangeCount) {
        this.colourChangeCount = colourChangeCount;
    }

    public Object getColourChangeList() {
        return colourChangeList;
    }

    public void setColourChangeList(Object colourChangeList) {
        this.colourChangeList = colourChangeList;
    }

    public Object getVicList() {
        return vicList;
    }

    public void setVicList(Object vicList) {
        this.vicList = vicList;
    }
}
