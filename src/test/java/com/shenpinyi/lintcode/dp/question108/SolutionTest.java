package com.shenpinyi.lintcode.dp.question108;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minCut() {
        assertEquals(1, new Solution().minCut("aab"));
        assertEquals(0, new Solution().minCut("aa"));
        assertEquals(0, new Solution().minCut(""));
        assertEquals(2, new Solution().minCut("abc"));
        assertEquals(0, new Solution().minCut("a"));
        assertEquals(1, new Solution().minCut("ab"));
    }
}