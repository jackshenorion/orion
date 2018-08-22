package com.shenpinyi.lintcode.arraynumbers.question43;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxSubArray() {
        int[] nums = {-1, 4, -2, 3, -2, 3};
        assertEquals(8, new Solution().maxSubArray(nums, 2));
        assertEquals(9, new Solution().maxSubArray(new int[]{5,4}, 2));
        assertEquals(1215, new Solution().maxSubArray(new int[]{2, -1, 3, -4, 5, -8, 6, -7, 200, -100, 1000}, 5));
    }

    @Test
    public void getMaxSums() {
        int[] nums = {-1, 4, -2, 3, -2, 3};
        int[][] maxSums = new Solution().getMaxSums(nums);
        assertArrayEquals(new int[][]{
                {-1, 4, 4, 5, 5, 6},
                {0, 4, 4, 5, 5, 6},
                {0, 0, -2, 3, 3, 4},
                {0, 0, 0, 3, 3, 4},
                {0, 0, 0, 0, -2, 3},
                {0, 0, 0, 0, 0, 3},
        }, maxSums);
    }
}