package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 02/04/21.
 */
public class ValuationListModel implements Serializable {
    @SerializedName("OTR")
    @Expose
    private String otr;
    @SerializedName("DealerForecourt")
    @Expose
    private String dealerForecourt;
    @SerializedName("TradeRetail")
    @Expose
    private String tradeRetail;
    @SerializedName("PrivateClean")
    @Expose
    private String privateClean;
    @SerializedName("PrivateAverage")
    @Expose
    private String privateAverage;
    @SerializedName("PartExchange")
    @Expose
    private String partExchange;
    @SerializedName("Auction")
    @Expose
    private String auction;
    @SerializedName("TradeAverage")
    @Expose
    private String tradeAverage;
    @SerializedName("TradePoor")
    @Expose
    private String tradePoor;

    public String getOtr() {
        return otr;
    }

    public void setOtr(String otr) {
        this.otr = otr;
    }

    public String getDealerForecourt() {
        return dealerForecourt;
    }

    public void setDealerForecourt(String dealerForecourt) {
        this.dealerForecourt = dealerForecourt;
    }

    public String getTradeRetail() {
        return tradeRetail;
    }

    public void setTradeRetail(String tradeRetail) {
        this.tradeRetail = tradeRetail;
    }

    public String getPrivateClean() {
        return privateClean;
    }

    public void setPrivateClean(String privateClean) {
        this.privateClean = privateClean;
    }

    public String getPrivateAverage() {
        return privateAverage;
    }

    public void setPrivateAverage(String privateAverage) {
        this.privateAverage = privateAverage;
    }

    public String getPartExchange() {
        return partExchange;
    }

    public void setPartExchange(String partExchange) {
        this.partExchange = partExchange;
    }

    public String getAuction() {
        return auction;
    }

    public void setAuction(String auction) {
        this.auction = auction;
    }

    public String getTradeAverage() {
        return tradeAverage;
    }

    public void setTradeAverage(String tradeAverage) {
        this.tradeAverage = tradeAverage;
    }

    public String getTradePoor() {
        return tradePoor;
    }

    public void setTradePoor(String tradePoor) {
        this.tradePoor = tradePoor;
    }
}
