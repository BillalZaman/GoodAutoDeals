package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdPowerModel {
    @SerializedName("Bhp")
    @Expose
    private Integer bhp;
    @SerializedName("Rpm")
    @Expose
    private Object rpm;
    @SerializedName("Kw")
    @Expose
    private Object kw;

    public Integer getBhp() {
        return bhp;
    }

    public void setBhp(Integer bhp) {
        this.bhp = bhp;
    }

    public Object getRpm() {
        return rpm;
    }

    public void setRpm(Object rpm) {
        this.rpm = rpm;
    }

    public Object getKw() {
        return kw;
    }

    public void setKw(Object kw) {
        this.kw = kw;
    }
}
