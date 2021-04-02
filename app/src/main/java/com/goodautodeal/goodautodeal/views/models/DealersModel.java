package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class DealersModel {
    private String dealerImg;
    private String dealerName;
    private String dealerTotalCars;
    private String dealerAddress;

    public DealersModel(String dealerName, String dealerTotalCars, String dealerAddress) {
        this.dealerName = dealerName;
        this.dealerTotalCars = dealerTotalCars;
        this.dealerAddress = dealerAddress;
    }

    public String getDealerImg() {
        return dealerImg;
    }

    public void setDealerImg(String dealerImg) {
        this.dealerImg = dealerImg;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerTotalCars() {
        return dealerTotalCars;
    }

    public void setDealerTotalCars(String dealerTotalCars) {
        this.dealerTotalCars = dealerTotalCars;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }
}
