package com.shenpinyi.microsoft.questionFour;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayTest {

    @Test
    public void testGetMaxSubArray() throws Exception {
        int[] result = new MaxSubArray(new int[]{-2, 3, 10, -4, 8, 2, -5, -20, -2, 3, 10, -4, 7, 2, -5}).getMaxSubArray();
        for (int i = 0; i < result.length; i ++) {
            System.out.print(result[i] + " ");
        }
    }
}