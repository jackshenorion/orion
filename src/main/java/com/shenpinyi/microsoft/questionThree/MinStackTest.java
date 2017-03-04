package com.shenpinyi.microsoft.questionThree;

import static org.junit.Assert.*;


public class MinStackTest {

    @org.junit.Test
    public void testPop() throws Exception {
        MinStack<Integer> minStack = new MinStack<Integer>(10);
        minStack.push(10);
        minStack.push(15);
        minStack.push(20);
        minStack.push(5);
        minStack.push(9);
        minStack.push(8);
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
    }

    @org.junit.Test
    public void testPush() throws Exception {

    }

    @org.junit.Test
    public void testMin() throws Exception {

    }
}