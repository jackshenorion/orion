package com.shenpinyi.microsoft.question013;

import com.shenpinyi.utils.link.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 13/03/2017.
 */
public class TailKFinderTest {

    @Test
    public void testFind() throws Exception {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>()
            .add(1).add(2).add(3).add(4).add(5).add(6);
        System.out.println(list);
        System.out.println(TailKFinder.find(list, 3));
        System.out.println(TailKFinder.find(list, 6));
        System.out.println(TailKFinder.find(list, 10));
    }
}