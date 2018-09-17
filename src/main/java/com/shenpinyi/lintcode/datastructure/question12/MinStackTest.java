package com.shenpinyi.lintcode.datastructure.question12;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void push() {
        MinStack stack = new MinStack();
        stack.push(1);
        assertEquals(1, stack.pop());
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.min());
        stack.push(1);
        assertEquals(1, stack.min());
    }
}