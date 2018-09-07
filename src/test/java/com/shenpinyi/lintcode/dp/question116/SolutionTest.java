package com.shenpinyi.lintcode.dp.question116;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void canJump() {
        assertTrue(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        assertFalse(new Solution().canJump(new int[]{0, 8, 2, 0, 9}));
    }
}