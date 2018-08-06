package com.shenpinyi.designpattern.publisher;

public class Solution {

    public static void main(String[] args) {
        MessageCenter messageCenter = MessageCenterImpl.createMessageCenter();
        AlertsPublisher alertsPublisher = new AlertsPublisher(messageCenter);
        NewsPublisher newsPublisher = new NewsPublisher(messageCenter);
        AllInfoSubscriber allInfoSubscriber = new AllInfoSubscriber(messageCenter, "AllInfoSubscriber");
        NewsSubscriber newsSubscriber = new NewsSubscriber(messageCenter, "NewsSubscriber");
        alertsPublisher.addAlert("aaaaaaaaaaaaaaaaaaa");
        alertsPublisher.addAlert("bbbbbbbbbbbbbbbbbbb");
        alertsPublisher.addAlert("ccccccccccccccccccc");
        alertsPublisher.addAlert("ddddddddddddddddddd");
        newsPublisher.addNews("AAAAAAAAAAAAAAAAAAAA");
        newsPublisher.addNews("BBBBBBBBBBBBBBBBBBBB");
        newsPublisher.addNews("CCCCCCCCCCCCCCCCCCCC");
    }
}
