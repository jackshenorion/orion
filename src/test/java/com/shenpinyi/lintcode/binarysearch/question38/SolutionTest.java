package com.shenpinyi.lintcode.binarysearch.question38;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchMatrix() {
        int[][] nums = {
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10}
        };
        assertEquals(2, new Solution().searchMatrix(nums, 3));
    }
}