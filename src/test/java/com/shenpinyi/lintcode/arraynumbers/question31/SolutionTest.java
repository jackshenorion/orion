package com.shenpinyi.lintcode.arraynumbers.question31;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void partitionArray() {
        assertEquals(1, new Solution().partitionArray(new int[]{3,2,2,1}, 2));

    }
}