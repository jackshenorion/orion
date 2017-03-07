package com.shenpinyi.utils.link;

/**
 * Created by jack on 7/03/2017.
 */
public class SinglyLinkNode<T> {
    private SinglyLinkNode next;
    private T value;

    public SinglyLinkNode getNext() {
        return next;
    }

    public SinglyLinkNode setNext(SinglyLinkNode next) {
        this.next = next;
        return this;
    }

    public T getValue() {
        return value;
    }

    public SinglyLinkNode setValue(T value) {
        this.value = value;
        return this;
    }
}
