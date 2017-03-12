package com.shenpinyi.microsoft.question013;

import com.shenpinyi.utils.link.SinglyLinkNode;
import com.shenpinyi.utils.link.SinglyLinkedList;

import java.util.LinkedList;

/**
 * Created by jack on 13/03/2017.
 */
public class TailKFinder {
    public static <V> V find(SinglyLinkedList<V> list, int k) {
        if (k <= 0) {
            return null;
        }

        LinkedList<V> kList = new LinkedList();
        int sizeOfKList = 0;
        SinglyLinkNode<V> node = list.getHead().getNext();
        while (node != null) {
            if (sizeOfKList >= k) {
                kList.pollFirst();
                sizeOfKList--;
            }
            kList.add(node.getValue());
            sizeOfKList++;
            node = node.getNext();
        }
        return sizeOfKList >= k ? kList.pollFirst() : null;
    }
}
