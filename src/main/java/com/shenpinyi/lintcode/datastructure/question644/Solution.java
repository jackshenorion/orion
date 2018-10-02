package com.shenpinyi.lintcode.datastructure.question644;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('8', '8');
        pairs.put('1', '1');
        pairs.put('0', '0');
        pairs.put('2', '2');
        pairs.put('6', '9');
        pairs.put('9', '6');
        pairs.put('5', '5');
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            char left = num.charAt(start);
            char right = num.charAt(end);
            if (!pairs.containsKey(left)) {
                return false;
            }
            if (pairs.get(left) != right) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
