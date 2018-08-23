package com.shenpinyi.lintcode.arraynumbers.question56;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void twoSum() {
        assertArrayEquals(new int[]{0, 1}, new Solution().twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}