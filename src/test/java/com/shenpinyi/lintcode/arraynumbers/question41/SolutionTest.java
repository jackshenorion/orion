package com.shenpinyi.lintcode.arraynumbers.question41;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxSubArray() {

        assertEquals(6, new Solution().maxSubArray(new int[] {-2,2,-3,4,-1,2,1,-5,3}));
    }

    @Test
    public void maxSubArray1() {

        assertEquals(-1, new Solution().maxSubArray(new int[] {-1}));
    }
}