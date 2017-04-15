package com.shenpinyi.leecode.question363;

import java.util.TreeSet;

/**
 * Created by jack on 14/04/2017.
 */
public class Solution {

    /**
     * Use O(n2) to sum up every rows from i to j.
     * Then apply 1D max sum sub array within K algorithm
     * 1D max sum sub-array use O(nlogn), so the whole algorithm is O(n3logn), which is better than brute force O(n4)
     * Choose the longer dimension to apply O(nlogn), and shorter dimension to apply O(n2)
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int height = matrix.length;
        if (height < 1) {return 0;}
        int width = matrix[0].length;
        if (width < 1) {return 0;}
        boolean isHeightBigger = height >= width;
        int row = Math.min(height, width);
        int col = Math.max(height, width);
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < row; i ++) {
            int[] sum = new int[col];
            for (int j = i; j < row; j ++) {
                int cum = 0;
                int currentSum = Integer.MIN_VALUE;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                set.add(Integer.MAX_VALUE);
                for (int m = 0; m < col; m ++) {
                    sum[m] += !isHeightBigger ? matrix[j][m] : matrix[m][j];
                    cum += sum[m];
                    int closestCum = set.ceiling(cum - k);
                    set.add(cum);
                    if (closestCum != Integer.MAX_VALUE) {
                        currentSum = cum - closestCum;
                        maxSum = Math.max(maxSum, currentSum);
                    }
                }
            }
        }

        return maxSum;
    }

    public int maxSumSubmatrix_timeout2(int[][] matrix, int k) {
        int height = matrix.length;
        if (height < 1) {return 0;}
        int width = matrix[0].length;
        if (width < 1) {return 0;}

        int maxSum = Integer.MIN_VALUE;
        int[][][] c_r_i_j = new int[height][width][width];
        for (int r = 0; r < height; r ++) {
            for (int j = 0; j < width; j++) {
                int current = matrix[r][j];
                for (int i = 0; i <= j; i++) {
                    if (i == j) {
                        c_r_i_j[r][j][j] = current;
                    } else {
                        c_r_i_j[r][i][j] = c_r_i_j[r][i][j - 1] + current;
                    }

                    for (int e = 0; e <= r; e++) {
                        int currentSum = 0;
                        if (r == e) {
                            currentSum = c_r_i_j[r][i][j];
                        } else {
                            currentSum = c_r_i_j[e][i][j] = c_r_i_j[e][i][j] + c_r_i_j[r][i][j];
                        }
                        if (currentSum > maxSum && currentSum <= k) {
                            maxSum = currentSum;
                            if (maxSum == k) {
                                return k;
                            }
                        }
                    }
                }
            }
        }

        return maxSum;
    }

    public int maxSumSubmatrix_timeout(int[][] matrix, int k) {
        int height = matrix.length;
        if (height < 1) {return 0;}
        int width = matrix[0].length;
        if (width < 1) {return 0;}

        int[][][] c_r_i_j = new int[height][][];
        for (int r = 0; r < height; r ++) {
            int[][] c_i_j = new int[width][width];
            c_r_i_j[r] = c_i_j;
            for (int j = 0; j < width; j ++) {
                c_i_j[j][j] = matrix[r][j];
                for (int i = 0; i < j; i ++) {
                    c_i_j[i][j] = c_i_j[i][j-1] + c_i_j[j][j];
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;

        int[][][] c_e_i_j = new int[height][width][width];
        for (int e = 0; e < height; e ++) {
            for (int i = 0; i < width; i ++) {
                for ( int j = i; j < width; j ++) {
                    for (int r = 0; r <= e; r ++) {
                        int currentSum = 0;
                        if (r == e) {
                            currentSum = c_e_i_j[e][i][j] = c_r_i_j[e][i][j];
                        } else {
                            currentSum = c_e_i_j[r][i][j] = c_e_i_j[r][i][j] + c_r_i_j[e][i][j];
                        }
                        if (currentSum > maxSum && currentSum <= k) {
                            maxSum = currentSum;
                            if (maxSum == k) {
                                return k;
                            }
                        }
                    }
                }
            }
        }
        return maxSum;
    }
}
