package com.shenpinyi.lintcode.binarysearch.question75;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findPeak() {
        int peak = new Solution().findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6});
        assertTrue(peak == 1 || peak == 6);
    }
}