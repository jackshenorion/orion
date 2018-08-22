package com.shenpinyi.lintcode.arraynumbers.question45;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxDiffSubArrays() {
        int[] nums = new int[]{1, 2, -3, 1};
        assertEquals(6, new Solution().maxDiffSubArrays(nums));
    }

    @Test
    public void createLeftMaxSums() {
        int[] nums = new int[]{1, 2, -3, 1};
        assertArrayEquals(new int[]{1, 3, 3, 3}, new Solution().createLeftMaxSums(nums));
    }

    @Test
    public void createRightMaxSums() {
        int[] nums = new int[]{1, 2, -3, 1};
        assertArrayEquals(new int[]{3, 2, 1, 1}, new Solution().createRightMaxSums(nums));
    }

    @Test
    public void createLeftMinSums() {
        int[] nums = new int[]{1, 2, -3, 1};
        assertArrayEquals(new int[]{1, 1, -3, -3}, new Solution().createLeftMinSums(nums));
    }

    @Test
    public void createRightMinSums() {
        int[] nums = new int[]{1, 2, -3, 1};
        assertArrayEquals(new int[]{-3, -3, -3, 1}, new Solution().createRightMinSums(nums));
    }
}