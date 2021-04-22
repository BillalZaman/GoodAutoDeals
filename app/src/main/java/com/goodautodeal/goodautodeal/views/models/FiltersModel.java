package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 22/04/21.
 */
public class FiltersModel {
    private String filterHeading;

    public FiltersModel(String filterHeading) {
        this.filterHeading = filterHeading;
    }

    public String getFilterHeading() {
        return filterHeading;
    }

    public void setFilterHeading(String filterHeading) {
        this.filterHeading = filterHeading;
    }
}
