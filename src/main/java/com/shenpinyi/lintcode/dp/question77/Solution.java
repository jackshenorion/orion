package com.shenpinyi.lintcode.dp.question77;

public class Solution {

    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() < 1 || B == null || B.length() < 1) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int[][] lcs = new int[lenA][lenB];
        boolean foundB = false;
        for (int j = 0; j < lenB; j++) {
            if (foundB || A.charAt(0) == B.charAt(j)) {
                lcs[0][j] = 1;
                foundB = true;
            } else {
                lcs[0][j] = 0;
            }
        }

        boolean foundA = false;
        for (int i = 0; i < lenA; i ++) {
            if (foundA || A.charAt(i) == B.charAt(0)) {
                lcs[i][0] = 1;
                foundA = true;
            } else {
                lcs[i][0] = 0;
            }
        }

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                int v1 = lcs[i-1][j];
                int v2 = lcs[i][j-1];
                int v3 = A.charAt(i) == B.charAt(j) ? lcs[i-1][j-1] + 1 : lcs[i-1][j-1];
                lcs[i][j] = Math.max(v1, Math.max(v2, v3));
            }
        }
        return lcs[lenA - 1][lenB - 1];
    }
}
