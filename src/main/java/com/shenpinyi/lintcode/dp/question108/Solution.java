package com.shenpinyi.lintcode.dp.question108;

public class Solution {

    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] cuts = new int[s.length()];
        cuts[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                cuts[i] = 0;
                continue;
            }
            cuts[i] = -1;
            int minCut = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (cuts[j] >= 0 && isPalindrome(s, j + 1, i)) {
                    minCut = Math.min(minCut, cuts[j] + 1);
                }
            }
            if (minCut != Integer.MAX_VALUE) {
                cuts[i] = minCut;
            }
        }
        return cuts[s.length() - 1];
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
