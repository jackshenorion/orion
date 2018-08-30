package com.shenpinyi.lintcode.binarysearch.question61;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchRange() {

        int[] nums = {5, 7, 7, 8, 8, 10};
        assertArrayEquals(new int[]{3,4}, new Solution().searchRange(nums, 8));

    }
}