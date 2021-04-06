package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 05/04/21.
 */
public class AdPerfomanceModel {
    @SerializedName("Power")
    @Expose
    private AdPowerModel power;

    public AdPowerModel getPower() {
        return power;
    }

    public void setPower(AdPowerModel power) {
        this.power = power;
    }
}
