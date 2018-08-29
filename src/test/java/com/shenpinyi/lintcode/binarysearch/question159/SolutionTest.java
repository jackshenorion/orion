package com.shenpinyi.lintcode.binarysearch.question159;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMin() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, new Solution().findMin(nums));
        assertEquals(1, new Solution().findMin(new int[]{1,2,3}));
        assertEquals(1, new Solution().findMin(new int[]{3,1,2}));
    }
}