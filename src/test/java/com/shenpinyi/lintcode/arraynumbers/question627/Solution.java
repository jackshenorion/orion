package com.shenpinyi.lintcode.arraynumbers.question627;

import java.util.HashMap;

public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        int[] stat = new int[255];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stat[c] ++;
        }
        int len = 0;
        boolean hasSingle = false;
        for (int i = 0; i < stat.length; i++ ) {
            int count = stat[i];
            int pair = count / 2;
            hasSingle |= ((count % 2) == 1);
            len += pair * 2;
        }
        return hasSingle ? len + 1 : len;
    }
}
