package com.goodautodeal.goodautodeal.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 21/04/21.
 */
@Entity(tableName = "favourite_table")
public class FavouriteModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "adTitle")
    private String adTitle;

    @ColumnInfo(name = "adPrice")
    private String adPrice;

    @ColumnInfo(name = "adImage")
    private String adImage;

    @ColumnInfo(name = "adSpecification")
    private String adSpecification;

    public FavouriteModel() {
    }

    public FavouriteModel(String adTitle, String adPrice, String adImage, String adSpecification) {
        this.adTitle = adTitle;
        this.adPrice = adPrice;
        this.adImage = adImage;
        this.adSpecification = adSpecification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
    }

    public String getAdSpecification() {
        return adSpecification;
    }

    public void setAdSpecification(String adSpecification) {
        this.adSpecification = adSpecification;
    }
}
