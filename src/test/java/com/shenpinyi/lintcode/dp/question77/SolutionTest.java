package com.shenpinyi.lintcode.dp.question77;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestCommonSubsequence() {
        assertEquals(1, new Solution().longestCommonSubsequence("ABCD", "EDCA"));
        assertEquals(2, new Solution().longestCommonSubsequence("ABCD", "EACB"));
    }
}