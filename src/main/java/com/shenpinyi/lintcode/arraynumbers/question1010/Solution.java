package com.shenpinyi.lintcode.arraynumbers.question1010;

public class Solution {

    /**
     *
     * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
     * Output: 35
     * Explanation:
     * The grid is:
     * [ [3, 0, 8, 4],
     *   [2, 4, 5, 7],
     *   [9, 2, 6, 3],
     *   [0, 3, 1, 0] ]
     *
     * The skyline viewed from top or bottom is: [9, 4, 8, 7]
     * The skyline viewed from left or right is: [8, 7, 9, 3]
     *
     * The grid after increasing the height of buildings without affecting skylines is:
     *
     * gridNew = [ [8, 4, 8, 7],
     *             [7, 4, 7, 7],
     *             [9, 4, 8, 7],
     *             [3, 3, 3, 3] ]
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(solution.maxAdd(grid));

    }

    public int maxAdd(int[][] grid) {
        int[] skylineTop = getSkylineTop(grid);
        int[] skylineLeft = getSkylineLeft(grid);
        int[][] gridNew = getNewGrid(skylineTop, skylineLeft);
        int length = grid.length;
        int total = 0;
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j++) {
                total += gridNew[i][j] - grid[i][j];
            }
        }
        return total;
    }

    private int[][] getNewGrid(int[] skylineTop, int[] skylineLeft) {
        int length = skylineTop.length;
        int[][] gridNew = new int[length][length];
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j++) {
                gridNew[i][j] = Math.min(skylineTop[i], skylineLeft[j]);
            }
        }
        return gridNew;
    }

    private int[] getSkylineTop(int[][] grid) {
        int[] skyline = new int[grid.length];
        for (int j  = 0; j < grid.length; j++) {
            int maxHeight = 0;
            for (int i = 0; i < grid.length; i++) {
                maxHeight = Math.max(grid[i][j], maxHeight);
            }
            skyline[j] = maxHeight;
        }
        return skyline;
    }

    private int[] getSkylineLeft(int[][] grid) {
        int[] skyline = new int[grid.length];
        for (int i  = 0; i < grid.length; i++) {
            int maxHeight = 0;
            for (int j = 0; j < grid.length; j++) {
                maxHeight = Math.max(grid[i][j], maxHeight);
            }
            skyline[i] = maxHeight;
        }
        return skyline;
    }
}



