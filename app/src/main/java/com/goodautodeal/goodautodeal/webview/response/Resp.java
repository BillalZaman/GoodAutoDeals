package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.ValueYourCarModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 02/04/21.
 */
public class Resp implements Serializable {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("StatusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("DataItems")
    @Expose
    private ValueYourCarModel dataItems;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ValueYourCarModel getDataItems() {
        return dataItems;
    }

    public void setDataItems(ValueYourCarModel dataItems) {
        this.dataItems = dataItems;
    }

}
