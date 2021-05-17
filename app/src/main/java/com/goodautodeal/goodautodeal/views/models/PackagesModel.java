package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 29/03/21.
 */
public class PackagesModel {
    private String txtHeading;
    private String txtPricing;
    private String txtDuration;
    private String txtImages;
    private String txtVideo;
    private String txtOptions;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("silver")
    @Expose
    private Double silver;
    @SerializedName("gold")
    @Expose
    private Double gold;
    @SerializedName("diamond")
    @Expose
    private Double diamond;
    @SerializedName("platinum")
    @Expose
    private Double platinum;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public PackagesModel(String txtHeading, String txtPricing, String txtDuration, String txtImages, String txtVideo, String txtOptions) {
        this.txtHeading = txtHeading;
        this.txtPricing = txtPricing;
        this.txtDuration = txtDuration;
        this.txtImages = txtImages;
        this.txtVideo = txtVideo;
        this.txtOptions = txtOptions;
    }

    public String getTxtHeading() {
        return txtHeading;
    }

    public void setTxtHeading(String txtHeading) {
        this.txtHeading = txtHeading;
    }

    public String getTxtPricing() {
        return txtPricing;
    }

    public void setTxtPricing(String txtPricing) {
        this.txtPricing = txtPricing;
    }

    public String getTxtDuration() {
        return txtDuration;
    }

    public void setTxtDuration(String txtDuration) {
        this.txtDuration = txtDuration;
    }

    public String getTxtImages() {
        return txtImages;
    }

    public void setTxtImages(String txtImages) {
        this.txtImages = txtImages;
    }

    public String getTxtVideo() {
        return txtVideo;
    }

    public void setTxtVideo(String txtVideo) {
        this.txtVideo = txtVideo;
    }

    public String getTxtOptions() {
        return txtOptions;
    }

    public void setTxtOptions(String txtOptions) {
        this.txtOptions = txtOptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getSilver() {
        return silver;
    }

    public void setSilver(Double silver) {
        this.silver = silver;
    }

    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }

    public Double getDiamond() {
        return diamond;
    }

    public void setDiamond(Double diamond) {
        this.diamond = diamond;
    }

    public Double getPlatinum() {
        return platinum;
    }

    public void setPlatinum(Double platinum) {
        this.platinum = platinum;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
