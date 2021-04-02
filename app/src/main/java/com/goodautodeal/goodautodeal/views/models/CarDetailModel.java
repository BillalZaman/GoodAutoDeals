package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 23/02/21.
 */
public class CarDetailModel {
    private String heading;
    private String detail;

    public CarDetailModel(String heading, String detail) {
        this.heading = heading;
        this.detail = detail;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
