package com.shenpinyi.lintcode.dp.question114;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(4,5));
    }
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        // use an int[] to record inter results
        int rows = m;
        int columns = n;
        int[] results = new int[columns];
        // init first row to 1
        for (int i = 0; i < columns; i ++) {
            results[i] = 1;
        }
        // from the second line, calculate each one f(x,y) = f(x-1, y) + f(x, y - 1)
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                results[column] = results[column - 1] + results[column];
            }
        }
        return results[columns - 1];
    }
}
