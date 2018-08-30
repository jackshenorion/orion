package com.shenpinyi.lintcode.binarysearch.question38;

public class Solution {

    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[rows - 1][cols - 1] < target) {
            return 0;
        }
        int row = rows - 1;
        int col = 0;
        int result = 0;
        while(row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                result ++;
                row--;
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return result;
    }
}
