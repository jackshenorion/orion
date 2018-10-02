package com.shenpinyi.lintcode.arraynumbers.question913;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    Map<String, Boolean> canWins = new HashMap<>();

    public boolean canWin(String s) {
        if (canWins.containsKey(s)) {
            return canWins.get(s);
        }
        boolean result = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                char[] cs = s.toCharArray();
                cs[i] = '-';
                cs[i + 1] = '-';
                result |= !canWin(new String(cs));
            }
        }
        canWins.putIfAbsent(s, result);
        return result;
    }
}
