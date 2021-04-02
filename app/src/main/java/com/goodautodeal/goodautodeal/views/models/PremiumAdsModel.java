package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 18/02/21.
 */
public class PremiumAdsModel {
    private String adImg;
    private String adTitle;
    private String adPrice;
    private String adYear;
    private String adMileage;
    private String adEngine;

    public PremiumAdsModel(String adTitle, String adPrice, String adYear, String adMileage, String adEngine) {
        this.adTitle = adTitle;
        this.adPrice = adPrice;
        this.adYear = adYear;
        this.adMileage = adMileage;
        this.adEngine = adEngine;
    }

    public PremiumAdsModel() {
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(String adPrice) {
        this.adPrice = adPrice;
    }

    public String getAdYear() {
        return adYear;
    }

    public void setAdYear(String adYear) {
        this.adYear = adYear;
    }

    public String getAdMileage() {
        return adMileage;
    }

    public void setAdMileage(String adMileage) {
        this.adMileage = adMileage;
    }

    public String getAdEngine() {
        return adEngine;
    }

    public void setAdEngine(String adEngine) {
        this.adEngine = adEngine;
    }
}
