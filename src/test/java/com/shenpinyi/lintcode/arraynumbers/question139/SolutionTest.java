package com.shenpinyi.lintcode.arraynumbers.question139;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subarraySumClosest() {

        int[] nums = {-3, 1, 1, -3, 5};
        int[] sub = new Solution().subarraySumClosest(nums);
        int sum = 0;
        for (int i = sub[0]; i < sub[1] + 1; i++) {
            sum += nums[i];
        }
        assertEquals(1, Math.abs(sum));
    }

    @Test
    public void subarraySumClosest2() {

        int[] nums = {2147483647};
        int[] sub = new int[]{0,0};
        assertArrayEquals(sub, new Solution().subarraySumClosest(nums));
    }
}