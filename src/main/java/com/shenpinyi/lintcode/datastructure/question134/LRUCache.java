package com.shenpinyi.lintcode.datastructure.question134;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
     * @param capacity: An integer
     */
    class Node {
        int val;
        Node next = null;
        Node prev = null;
        Node(int v) {
            this.val = v;
        }
    }
    private Node dummyHead;
    private Node dummyTail;
    private int count = 0;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.dummyHead = new Node(0);
        this.dummyTail = new Node(0);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.val;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
    private void addNode(Node node) {
        node.next = this.dummyHead.next;
        node.prev = this.dummyHead;
        this.dummyHead.next.prev = node;
        this.dummyHead.next = node;
    }
    private void removeLast() {
        Node node = this.dummyTail.prev;
        removeNode(node);
        map.remove(node.val);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (this.get(key) != -1) {
            return;
        }
        count++;
        if (count > capacity) {
            removeLast();
            count--;
        }
        Node node = new Node(value);
        map.put(key, node);
        addNode(node);
    }
}

