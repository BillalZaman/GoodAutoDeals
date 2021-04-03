package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdAccelerationModel implements Serializable {
    @SerializedName("Mph")
    @Expose
    private Double mph;
    @SerializedName("Kph")
    @Expose
    private Object kph;
    @SerializedName("ZeroTo60Mph")
    @Expose
    private Double zeroTo60Mph;
    @SerializedName("ZeroTo100Kph")
    @Expose
    private Object zeroTo100Kph;

    public Double getMph() {
        return mph;
    }

    public void setMph(Double mph) {
        this.mph = mph;
    }

    public Object getKph() {
        return kph;
    }

    public void setKph(Object kph) {
        this.kph = kph;
    }

    public Double getZeroTo60Mph() {
        return zeroTo60Mph;
    }

    public void setZeroTo60Mph(Double zeroTo60Mph) {
        this.zeroTo60Mph = zeroTo60Mph;
    }

    public Object getZeroTo100Kph() {
        return zeroTo100Kph;
    }

    public void setZeroTo100Kph(Object zeroTo100Kph) {
        this.zeroTo100Kph = zeroTo100Kph;
    }
}
