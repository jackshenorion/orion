package com.shenpinyi.lintcode.datastructure.question122;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void largestRectangleArea() {
        assertEquals(10, new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}