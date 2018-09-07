package com.shenpinyi.lintcode.dp.question107;

import java.util.Set;

public class Solution {

    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLen = getMaxLen(dict);
        boolean[] breakable = new boolean[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            breakable[i] = false;
            if (i <= maxLen && dict.contains(s.substring(0, i + 1))) {
                breakable[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (breakable[j] && (i - j) <= maxLen && dict.contains(s.substring(j + 1, i + 1))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length() - 1];
    }

    private int getMaxLen(Set<String> dict) {
        int max = 0;
        for (String s : dict) {
            max = Math.max(s.length(), max);
        }
        return max;
    }


    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
