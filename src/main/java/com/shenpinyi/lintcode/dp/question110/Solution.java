package com.shenpinyi.lintcode.dp.question110;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                {1,2,3},
                {3,4,5},
                {4,5,6}
        };

        System.out.println(solution.minPathSum(grid));
    }


    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        // have an int[] to record each layer's result
        int columns = grid[0].length;
        int rows = grid.length;
        int[] results = new int[columns];
        results[columns - 1] = grid[rows - 1][columns - 1];
        for (int i = columns - 2; i >= 0; i--) {
            results[i] = results[i + 1] + grid[rows - 1][i];
        }

        // from the second last row
        // from columns - 1 to 0, get min(right, down)
        for (int row = rows - 2; row >= 0; row--) {
            for (int column = columns - 1; column >= 0; column--) {
                if (column == columns - 1) {
                    results[column] = grid[row][column] + results[column];
                } else {
                    results[column] = grid[row][column] + Math.min(results[column + 1], results[column]);
                }
            }
        }
        return results[0];
    }
}
