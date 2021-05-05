package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 05/05/21.
 */
public class UploadImageListModel {
    private String imagePath;
    private boolean isSelected;

    public UploadImageListModel(String imagePath, boolean isSelected) {
        this.imagePath = imagePath;
        this.isSelected = isSelected;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
