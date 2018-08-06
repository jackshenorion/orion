package com.shenpinyi.designpattern.publisher;

public class NewsSubscriber implements Subscriber{

    private String name;

    public NewsSubscriber(MessageCenter messageCenter, String name) {
        this.name = name;
        messageCenter.subscribe("news", this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String topic, Object msg) {
        System.out.println(String.format("Subscriber %s received a %s: %s", name, topic, msg));
    }
}
