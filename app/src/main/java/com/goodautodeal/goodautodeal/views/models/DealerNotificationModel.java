package com.goodautodeal.goodautodeal.views.models;

/**
 * Created by Bilal Zaman on 25/02/21.
 */
public class DealerNotificationModel {
    private String notificationTitle;
    private String notificationDescription;

    public DealerNotificationModel(String notificationTitle, String notificationDescription) {
        this.notificationTitle = notificationTitle;
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }
}
