package com.shenpinyi.designpattern.publisher;

public interface MessageCenter {
    void addTopic(String topic);
    void notify(String topic, Object msg);
    void subscribe(String topic, Subscriber subscriber);
    void unSubscribe(String topic, Subscriber subscriber);
}
