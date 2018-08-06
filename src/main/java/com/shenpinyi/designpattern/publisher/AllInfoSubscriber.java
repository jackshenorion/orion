package com.shenpinyi.designpattern.publisher;

public class AllInfoSubscriber implements Subscriber {

    private String name;

    public AllInfoSubscriber(MessageCenter messageCenter, String name) {
        this.name = name;
        messageCenter.subscribe("alerts", this);
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
