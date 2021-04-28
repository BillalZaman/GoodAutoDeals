package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 27/04/21.
 */
public class AdVideoModel {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("ad_id")
    @Expose
    private int ad_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }
}
