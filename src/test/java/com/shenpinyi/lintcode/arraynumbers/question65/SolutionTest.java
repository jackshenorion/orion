package com.shenpinyi.lintcode.arraynumbers.question65;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMedianSortedArrays() {
        assertEquals(3.5, new Solution().findMedianSortedArrays(new int[]{1,2,3,4,5,6}, new int[]{2,3,4,5}), 0.001);
        assertEquals(3, new Solution().findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5}), 0.001);
    }
}