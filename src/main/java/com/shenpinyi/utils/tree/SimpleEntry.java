package com.shenpinyi.utils.tree;

/**
 * Created by jack on 10/03/2017.
 */
public class SimpleEntry<T> {
    T value;
    SimpleEntry<T> left;
    SimpleEntry<T> right;
    SimpleEntry<T> parent;

    public T getValue() {
        return value;
    }

    public SimpleEntry setValue(T value) {
        this.value = value;
        return this;
    }

    public SimpleEntry<T> getLeft() {
        return left;
    }

    public SimpleEntry setLeft(SimpleEntry<T> left) {
        this.left = left;
        return this;
    }

    public SimpleEntry<T> getRight() {
        return right;
    }

    public SimpleEntry setRight(SimpleEntry<T> right) {
        this.right = right;
        return this;
    }

    public SimpleEntry<T> getParent() {
        return parent;
    }

    public SimpleEntry setParent(SimpleEntry<T> parent) {
        this.parent = parent;
        return this;
    }
}
