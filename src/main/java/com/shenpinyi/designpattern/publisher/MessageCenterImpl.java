package com.shenpinyi.designpattern.publisher;

import java.util.*;

public class MessageCenterImpl implements MessageCenter {

//    private Map<String, Queue<Object>> topicToMessages = new HashMap<>();
    private Set<String> topics = new HashSet<>();
    private Map<String, Map<String, Subscriber>> topicToSubscribers = new HashMap<>();

    public static MessageCenter createMessageCenter() {
        return new MessageCenterImpl();
    }

    @Override
    public void addTopic(String topic) {
        topics.add(topic);
    }

    @Override
    public void notify(String topic, Object msg) {
        if (!checkTopic(topic)) {
            return;
        }
        //topicToMessages.get(topic).offer(msg);
        if (topicToSubscribers.get(topic) == null) {
            return;
        }
        topicToSubscribers.get(topic).forEach((name, subscriber) -> subscriber.update(topic, msg));
    }

    @Override
    public void subscribe(String topic, Subscriber subscriber) {
        if (!checkTopic(topic)) {
            return;
        }
        topicToSubscribers.putIfAbsent(topic, new HashMap<>());
        topicToSubscribers.get(topic).put(subscriber.getName(), subscriber);
    }

    @Override
    public void unSubscribe(String topic, Subscriber subscriber) {
        if (!checkTopic(topic)) {
            return;
        }
        if (topicToSubscribers.containsKey(topic)) {
            topicToSubscribers.get(topic).remove(subscriber.getName());
        }
    }

    private boolean checkTopic(String topic) {
        return topics.contains(topic);
    }
}
