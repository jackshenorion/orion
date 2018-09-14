package com.shenpinyi.lintcode.dp.question29;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isInterleave() {

        assertTrue(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbccc"));

    }
}