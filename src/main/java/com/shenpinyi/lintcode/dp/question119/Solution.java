package com.shenpinyi.lintcode.dp.question119;

public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if ((word1 == null || word1.length() == 0)
                && (word2 == null || word2.length() == 0)) {
            return 0;
        } else if (word1 == null || word1.length() == 0) {
            return word2.length();
        } else if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();
        // matrix i,j, i for word1, j for word2, value is how many modifications
        int[][] dist = new int[len1 + 1][len2 + 1];
        dist[0][0] = 0;
        for (int i = 1; i < len1 + 1; i++) {
            dist[i][0] = i;
        }
        for (int j = 1; j < len2 + 1; j++) {
            dist[0][j] = j;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char current1 = word1.charAt(i - 1);
                char current2 = word2.charAt(j - 1);
                if (current1 == current2) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    int replace = dist[i - 1][j - 1] + 1;
                    int delete1 = dist[i - 1][j] + 1;
                    int delete2 = dist[i][j - 1] + 1;
                    dist[i][j] = Math.min(replace, Math.min(delete1, delete2));
                }
            }
        }
        return dist[len1][len2];
    }
}
