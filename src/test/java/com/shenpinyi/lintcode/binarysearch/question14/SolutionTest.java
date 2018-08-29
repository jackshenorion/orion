package com.shenpinyi.lintcode.binarysearch.question14;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void binarySearch() {

        int[] nums = new int[]{1,2,3,3,4,5,10};
        int position = new Solution().binarySearch(nums, 3);
        assertEquals(2, position);

    }
}