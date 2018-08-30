package com.shenpinyi.lintcode.binarysearch.question60;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchInsert() {
        int[] nums = {1, 3, 5, 6};
        assertEquals(2, new Solution().searchInsert(nums, 5));
        assertEquals(1, new Solution().searchInsert(nums, 2));
        assertEquals(4, new Solution().searchInsert(nums, 7));
        assertEquals(0, new Solution().searchInsert(nums, 0));
    }
}