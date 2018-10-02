package com.shenpinyi.lintcode.arraynumbers.question914;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 1) {
            return result;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                char[] cs = s.toCharArray();
                cs[i] = '-';
                cs[i + 1] = '-';
                result.add(new String(cs));
            }
        }
        return result;
    }
}
