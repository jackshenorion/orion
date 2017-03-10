package com.shenpinyi.utils.tree;

/**
 * Created by jack on 10/03/2017.
 */
public class Entry<K, V> {
    public K key;
    public V value;
    public Entry<K, V> left;
    public Entry<K, V> right;
    public Entry<K, V> parent;

    public Entry(K key, V value, Entry<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    public String toString() {
        return key + " = " + value;
    }
}
