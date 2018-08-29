package com.shenpinyi.lintcode.binarysearch.question28;

public class Solution {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 ) {
            return false;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;
        while (startRow + 1 < endRow) {
            int mid = startRow + (endRow - startRow) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                endRow = mid;
            } else {
                startRow = mid;
            }
        }
        int rowId = matrix[endRow][0] <= target ? endRow : startRow;

        int[] row = matrix[rowId];
        int start = 0;
        int end = row.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return row[start] == target || row[end] == target;
    }



}
