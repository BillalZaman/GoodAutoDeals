package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdTorqueModel {
    @SerializedName("FtLb")
    @Expose
    private Double ftLb;
    @SerializedName("Nm")
    @Expose
    private Integer nm;
    @SerializedName("Rpm")
    @Expose
    private Integer rpm;

    public Double getFtLb() {
        return ftLb;
    }

    public void setFtLb(Double ftLb) {
        this.ftLb = ftLb;
    }

    public Integer getNm() {
        return nm;
    }

    public void setNm(Integer nm) {
        this.nm = nm;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }
}
