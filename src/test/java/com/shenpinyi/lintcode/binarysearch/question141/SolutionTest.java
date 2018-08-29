package com.shenpinyi.lintcode.binarysearch.question141;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sqrt() {
        assertEquals(0, new Solution().sqrt(0));
        assertEquals(1, new Solution().sqrt(1));
        assertEquals(1, new Solution().sqrt(3));
        assertEquals(2, new Solution().sqrt(4));
        assertEquals(2, new Solution().sqrt(5));
        assertEquals(3, new Solution().sqrt(10));
    }
}