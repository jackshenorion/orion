package com.shenpinyi.microsoft.question007;

import com.shenpinyi.utils.link.SinglyLinkNode;
import com.shenpinyi.utils.link.SinglyLinkedList;

/**
 * Created by jack on 7/03/2017.
 */
public class LinkJointFinder {

    public static <T> boolean hasLoop(SinglyLinkedList<T> linkedList) {
        System.out.println("Begin: ");
        SinglyLinkNode faster = linkedList.getHead().getNext();
        SinglyLinkNode slower = linkedList.getHead();

        while (faster != null) {
            faster = faster.getNext();
            slower = slower.getNext();
            System.out.println("faster: " + (faster == null ? "null" : faster.getValue()) + ", slower: " + (slower == null ? "null" : slower.getValue()));
            if (faster == null || slower == null) {
                return false;
            } else if (faster == slower) {
                return true;
            } else {
                faster = faster.getNext();
                System.out.println("faster: " + (faster == null ? "null" : faster.getValue()) + ", slower: " + (slower == null ? "null" : slower.getValue()));
                if (faster == null) {
                    return false;
                } else if (faster == slower){
                    return true;
                }
            }
        }
        return false;
    }
}
