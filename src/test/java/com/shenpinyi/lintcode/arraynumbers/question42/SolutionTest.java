package com.shenpinyi.lintcode.arraynumbers.question42;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxTwoSubArrays() {
        assertEquals(7, new Solution().maxTwoSubArrays(Arrays.asList(1,3,-1,2,-1,2)));
        assertEquals(-2, new Solution().maxTwoSubArrays(Arrays.asList(-1,-2,-3,-100,-1,-50)));
    }

    @Test
    public void getLeftMaxSums() {
        assertArrayEquals(new int[]{1,4,4,5,5,6}, new Solution().getLeftMaxSums(Arrays.asList(1,3,-1,2,-1,2)));
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1,-1}, new Solution().getLeftMaxSums(Arrays.asList(-1,-2,-3,-100,-1,-50)));
    }

    @Test
    public void getRightmaxSums() {
        assertArrayEquals(new int[]{6,5,3,3,2,2}, new Solution().getRightMaxSums(Arrays.asList(1,3,-1,2,-1,2)));
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1,-50}, new Solution().getRightMaxSums(Arrays.asList(-1,-2,-3,-100,-1,-50)));
    }
}