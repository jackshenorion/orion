package com.shenpinyi.lintcode.dp.question109;

public class Solution {

    public static void main(String[] args) {
        int[][] triangle = new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}};
        System.out.println(new Solution().minimumTotal(triangle));
    }

    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        int lastLineIndex = triangle.length - 1;
        int lastLineLength = triangle.length;

        int[] results = new int[lastLineLength];
        for (int i = 0; i < lastLineLength; i++) {
            results[i] = triangle[lastLineIndex][i];
        }
        for (int i = lastLineIndex - 1; i >= 0; i --) {
            // i is the line we are calculating
            int currentLength = i + 1;
            for (int j = 0; j < currentLength; j++) {
                // j is the index we are calculating
                // each new result is the minimum of item on that line plus the same place on result and place + 1
                results[j] = triangle[i][j] + Math.min(results[j], results[j+1]);
            }
        }
        return results[0];
    }
}
