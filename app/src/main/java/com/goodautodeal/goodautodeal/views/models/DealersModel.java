package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class DealersModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("business_no")
    @Expose
    private String businessNo;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("trade_name")
    @Expose
    private String tradeName;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("company_reg_no")
    @Expose
    private String companyRegNo;
    @SerializedName("company_logo")
    @Expose
    private Object companyLogo;
    @SerializedName("no_of_cars")
    @Expose
    private String noOfCars;
    @SerializedName("avg_montly_selling")
    @Expose
    private Object avgMontlySelling;
    @SerializedName("sell_new_cars")
    @Expose
    private Integer sellNewCars;
    @SerializedName("sell_used_cars")
    @Expose
    private Integer sellUsedCars;
    @SerializedName("home_delivery")
    @Expose
    private Integer homeDelivery;
    @SerializedName("discounts")
    @Expose
    private Integer discounts;
    @SerializedName("slot_id")
    @Expose
    private Object slotId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public Object getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(Object companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getNoOfCars() {
        return noOfCars;
    }

    public void setNoOfCars(String noOfCars) {
        this.noOfCars = noOfCars;
    }

    public Object getAvgMontlySelling() {
        return avgMontlySelling;
    }

    public void setAvgMontlySelling(Object avgMontlySelling) {
        this.avgMontlySelling = avgMontlySelling;
    }

    public Integer getSellNewCars() {
        return sellNewCars;
    }

    public void setSellNewCars(Integer sellNewCars) {
        this.sellNewCars = sellNewCars;
    }

    public Integer getSellUsedCars() {
        return sellUsedCars;
    }

    public void setSellUsedCars(Integer sellUsedCars) {
        this.sellUsedCars = sellUsedCars;
    }

    public Integer getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(Integer homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public Integer getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Integer discounts) {
        this.discounts = discounts;
    }

    public Object getSlotId() {
        return slotId;
    }

    public void setSlotId(Object slotId) {
        this.slotId = slotId;
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

}
