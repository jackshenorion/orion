package com.shenpinyi.designpattern.publisher;

public interface Subscriber {
    String getName();
    void update(String topic, Object msg);
}
