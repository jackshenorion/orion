package com.shenpinyi.designpattern.publisher;

public class AlertsPublisher implements Publisher {

    private MessageCenter messageCenter;

    public AlertsPublisher(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
        this.messageCenter.addTopic("alerts");
    }

    public void addAlert(String alert) {
        messageCenter.notify("alerts", alert);
    }
}
