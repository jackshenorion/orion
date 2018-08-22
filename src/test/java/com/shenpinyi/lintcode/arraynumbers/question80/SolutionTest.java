package com.shenpinyi.lintcode.arraynumbers.question80;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void divide() {
        int[] nums = new int[]{4,5,1,2,3};
        int pivotIndex = new Solution().divide(nums, 0, 4);
        assertEquals(2, pivotIndex);
        for (int i = 0; i < pivotIndex; i ++) {
            assertTrue(nums[i] <= 3);
        }
        for (int i = pivotIndex + 1; i < nums.length; i ++) {
            assertTrue(nums[i] > 3);
        }
    }

    @Test
    public void median() {
        assertEquals(3, new Solution().median(new int[]{4,5,1,2,3}));
        assertEquals(5, new Solution().median(new int[]{7,9,4,5}));
        assertEquals(5, new Solution().median(new int[]{1,2,3,4,5,6,7,100,200,1000}));
        assertEquals(-3, new Solution().median(new int[]{-1,-2,-3,-100,-1,-50}));
    }
}