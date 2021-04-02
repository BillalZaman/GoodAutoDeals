package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 25/02/21.
 */
public class DealerDashboardModel {
    private int count;
    private String title;
    private String icon;

    public DealerDashboardModel(int count, String title, String icon) {
        this.count = count;
        this.title = title;
        this.icon = icon;
    }

    public DealerDashboardModel(int count, String total_jobs, int totalJobs) {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
