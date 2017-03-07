package com.shenpinyi.microsoft.question007;

import com.shenpinyi.utils.link.SinglyLinkNode;
import com.shenpinyi.utils.link.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 7/03/2017.
 */
public class LinkJointFinderTest {

    @Test
    public void testHasLoop() throws Exception {
        SinglyLinkedList<String> linkedList =
            new SinglyLinkedList<>().add("E").add("D").add("C").add("B").add("A");
        System.out.println(LinkJointFinder.hasLoop(linkedList));

        SinglyLinkNode entryPoint = linkedList.find("C");
        SinglyLinkNode endPoint = linkedList.find("E");
        endPoint.setNext(entryPoint);
        System.out.println(LinkJointFinder.hasLoop(linkedList));
    }
}