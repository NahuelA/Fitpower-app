package fitpower.model.assessment;

import fitpower.model.base.Date;

import java.util.HashMap;

public class Notification extends Date {

    public final HashMap<String, Notification> notificationMap = new HashMap<>();

    private String notificationId;
    private String clientDni;
    private String sender;
    private String details;
    private String recommendation;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
