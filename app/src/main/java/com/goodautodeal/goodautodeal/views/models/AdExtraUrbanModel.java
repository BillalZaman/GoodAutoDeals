package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdExtraUrbanModel {

    @SerializedName("Lkm")
    @Expose
    private Double lkm;
    @SerializedName("Mpg")
    @Expose
    private Double mpg;


    public Double getLkm() {
        return lkm;
    }

    public void setLkm(Double lkm) {
        this.lkm = lkm;
    }

    public Double getMpg() {
        return mpg;
    }

    public void setMpg(Double mpg) {
        this.mpg = mpg;
    }
}
