package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.AdDataItemsModel;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class Response {
    @SerializedName("status")
    @Expose
    private String success;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("DataObject")
    @Expose
    private DataObject dataObject;
    @SerializedName("Response")
    @Expose
    private Resp resp;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
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

    public DataObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public Resp getResp() {
        return resp;
    }

    public void setResp(Resp resp) {
        this.resp = resp;
    }
}
