package com.goodautodeal.goodautodeal.views.models;

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
}
