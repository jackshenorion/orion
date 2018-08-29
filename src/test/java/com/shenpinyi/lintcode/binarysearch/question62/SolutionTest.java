package com.shenpinyi.lintcode.binarysearch.question62;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search() {
        assertEquals(2, new Solution().search(new int[]{4,5,1,2,3}, 1));
        assertEquals(0, new Solution().search(new int[]{4,5,1,2,3}, 4));
        assertEquals(1, new Solution().search(new int[]{4,5,1,2,3}, 5));
        assertEquals(3, new Solution().search(new int[]{4,5,1,2,3}, 2));
        assertEquals(4, new Solution().search(new int[]{4,5,1,2,3}, 3));
        assertEquals(-1, new Solution().search(new int[]{4,5,1,2,3}, 0));
    }
}