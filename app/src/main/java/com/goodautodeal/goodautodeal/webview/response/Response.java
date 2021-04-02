package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.ValueYourCarModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class Response {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status_code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private DataObject dataObject;

    public DataObject getDataObject() {
        return dataObject;
    }

    @SerializedName("Response")
    @Expose
    private Resp valueYourCarModel;

    public Resp getValueYourCarModel() {
        return valueYourCarModel;
    }

    public void setValueYourCarModel(Resp valueYourCarModel) {
        this.valueYourCarModel = valueYourCarModel;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
