package com.shenpinyi.lintcode.arraynumbers.question157;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        int[] stat = new int[255];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stat[c]++;
            if (stat[c] > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isUniqueB(String str) {
        // write your code here
        Map<Character, Integer> stat = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stat.putIfAbsent(c, 0);
            stat.put(c, stat.get(c) + 1);
        }
        for (char c : stat.keySet()) {
            if (stat.get(c) > 1) {
                return false;

            }
        }
        return true;
    }
}
