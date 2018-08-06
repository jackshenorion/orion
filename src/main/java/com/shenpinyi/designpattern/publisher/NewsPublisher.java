package com.shenpinyi.designpattern.publisher;

public class NewsPublisher {
    private MessageCenter messageCenter;

    public NewsPublisher(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
        this.messageCenter.addTopic("news");
    }

    public void addNews(String news) {
        messageCenter.notify("news", news);
    }
}
