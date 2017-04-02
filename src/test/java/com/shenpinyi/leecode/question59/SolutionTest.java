package com.shenpinyi.leecode.question59;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 1/04/2017.
 */
public class SolutionTest {

    @Test
    public void testGenerateMatrix() throws Exception {
        int n = 5;
        int[][] a = new Solution().generateMatrix(n);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(a[i][j] + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}