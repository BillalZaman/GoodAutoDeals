package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 19/04/21.
 */
public class DealerPersonalModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("provider")
    @Expose
    private Object provider;
    @SerializedName("provider_id")
    @Expose
    private Object providerId;
    @SerializedName("cell_no")
    @Expose
    private String cellNo;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("post_code")
    @Expose
    private String postCode;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("isVerify")
    @Expose
    private Integer isVerify;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("dealer_id")
    @Expose
    private Integer dealerId;
    @SerializedName("email_verify_otp")
    @Expose
    private Object emailVerifyOtp;
    @SerializedName("forgot_pass_otp")
    @Expose
    private Object forgotPassOtp;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("dealer")
    @Expose
    private DealersModel dealer;
    private Boolean isExpendable;

    public Boolean getExpendable() {
        return isExpendable;
    }

    public void setExpendable(Boolean expendable) {
        isExpendable = expendable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Object getProvider() {
        return provider;
    }

    public void setProvider(Object provider) {
        this.provider = provider;
    }

    public Object getProviderId() {
        return providerId;
    }

    public void setProviderId(Object providerId) {
        this.providerId = providerId;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(Integer isVerify) {
        this.isVerify = isVerify;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Object getEmailVerifyOtp() {
        return emailVerifyOtp;
    }

    public void setEmailVerifyOtp(Object emailVerifyOtp) {
        this.emailVerifyOtp = emailVerifyOtp;
    }

    public Object getForgotPassOtp() {
        return forgotPassOtp;
    }

    public void setForgotPassOtp(Object forgotPassOtp) {
        this.forgotPassOtp = forgotPassOtp;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DealersModel getDealer() {
        return dealer;
    }

    public void setDealer(DealersModel dealer) {
        this.dealer = dealer;
    }
}
