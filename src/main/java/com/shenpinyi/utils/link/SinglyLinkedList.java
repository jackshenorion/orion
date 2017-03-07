package com.shenpinyi.utils.link;

/**
 * Created by jack on 7/03/2017.
 */
public class SinglyLinkedList <T> {
    SinglyLinkNode<T> head = new SinglyLinkNode<>().setValue(null).setNext(null);

    public SinglyLinkNode<T> getHead() {
        return head;
    }

    public SinglyLinkedList add(T nodeValue) {
        head.setNext(new SinglyLinkNode<T>().setValue(nodeValue).setNext(head.getNext()));
        return this;
    }

    public SinglyLinkNode<T> find(T value) {
        SinglyLinkNode current = head.getNext();
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
