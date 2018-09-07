package com.shenpinyi.lintcode.dp.question76;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestIncreasingSubsequence() {
        assertEquals(3, new Solution().longestIncreasingSubsequence(new int[]{5,4,1,2,3}));
        assertEquals(4, new Solution().longestIncreasingSubsequence(new int[]{4,2,4,5,3,7}));
        assertEquals(1, new Solution().longestIncreasingSubsequence(new int[]{1,1,1,1,1,1}));
        assertEquals(4, new Solution().longestIncreasingSubsequence(new int[]{10,1,11,2,12,3,11}));
        assertEquals(10, new Solution().longestIncreasingSubsequence(new int[]{88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59}));
    }
}