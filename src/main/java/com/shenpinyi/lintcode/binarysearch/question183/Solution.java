package com.shenpinyi.lintcode.binarysearch.question183;

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length < 1) {
            return 0;
        }
        long totalLen = 0;
        int maxLen = 0;
        for (int len : L) {
            totalLen += len;
            maxLen = Math.max(maxLen, len);
        }
        if (totalLen < k) {
            return 0;
        }
        int startLen = 1;
        int endLen = maxLen;
        while (startLen + 1 < endLen) {
            int midLen = startLen + (endLen - startLen) / 2;
            if (canCut(L, midLen, k)) {
                startLen = midLen;
            } else {
                endLen = midLen;
            }
        }
        return canCut(L, endLen, k) ? endLen : startLen;
    }

    private boolean canCut(int[] L, int len, int k) {
        int num = 0;
        for (int l : L) {
            num += l / len;
        }
        return num >= k;
    }

}
