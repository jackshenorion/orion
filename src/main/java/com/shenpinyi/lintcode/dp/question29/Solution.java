package com.shenpinyi.lintcode.dp.question29;

public class Solution {

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        } else if (len3 == 0) {
            return true;
        }
        boolean[][] results = new boolean[len1 + 1][len2 + 1];
        results[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            results[i][0] = false;
        }
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                results[i][0] = true;
            } else {
                break;
            }
        }
        for (int j = 1; j <= len2; j++) {
            results[0][j] = false;
        }
        for (int j = 1; j <= len2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                results[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if (c1 != c3 && c2 != c3) {
                    results[i][j] = false;
                } else if (c1 == c3 && c2 == c3) {
                    results[i][j] = results[i - 1][j] || results[i][j - 1];
                } else if (c1 == c3) {
                    results[i][j] = results[i - 1][j];
                } else { // c2 == c3
                    results[i][j] = results[i][j - 1];
                }
            }
        }
        return results[len1][len2];
    }
}
