package com.shenpinyi.algorithms.chapter22;

/**
 * Created by sj on 2017/3/4.
 */
public class Vertex <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public Vertex setValue(T value) {
        this.value = value;
        return this;
    }
}
