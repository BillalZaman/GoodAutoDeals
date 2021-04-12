package com.goodautodeal.goodautodeal.webview.response;

import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.views.models.ValueYourCarModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class DataObject implements Serializable {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;
    @SerializedName("UserInfo")
    @Expose
    private UserInfoModel userInfo;
    @SerializedName("DataItems")
    @Expose
    private ValueYourCarModel valueYourCarModel;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public UserInfoModel getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoModel userInfo) {
        this.userInfo = userInfo;
    }

    public ValueYourCarModel getValueYourCarModel() {
        return valueYourCarModel;
    }

    public void setValueYourCarModel(ValueYourCarModel valueYourCarModel) {
        this.valueYourCarModel = valueYourCarModel;
    }
}
