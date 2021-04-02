package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.ValueYourCarModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class DataObject implements Serializable {
    @SerializedName("DataItems")
    @Expose
    private ValueYourCarModel valueYourCarModel;

    public ValueYourCarModel getValueYourCarModel() {
        return valueYourCarModel;
    }

    public void setValueYourCarModel(ValueYourCarModel valueYourCarModel) {
        this.valueYourCarModel = valueYourCarModel;
    }
}
