package com.shenpinyi.lintcode.heap.question130;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void heapify() {
        Solution solution = new Solution();
        int[] a = new int[]{3,2,1,4,5};
        solution.heapify(a);
        assertArrayEquals(new int[]{1,2,3,4,5}, a);
    }
}