package com.shenpinyi.lintcode.binarysearch.question28;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchMatrix() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assertTrue(new Solution().searchMatrix(matrix, 3));
        assertFalse(new Solution().searchMatrix(matrix, 15));
        assertFalse(new Solution().searchMatrix(new int[0][], 15));
        assertFalse(new Solution().searchMatrix(matrix, 0));
        assertFalse(new Solution().searchMatrix(matrix, 51));
        assertTrue(new Solution().searchMatrix(matrix, 1));
        assertTrue(new Solution().searchMatrix(matrix, 50));
    }
}