package com.shenpinyi.lintcode.arraynumbers.question209;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public char firstUniqChar(String str) {
        long[] cs = new long[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cs[c]++;
        }
        for (char i = 0; i < cs.length; i++) {
            if (cs[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public char firstUniqCharB(String str) {
        Map<Character, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.putIfAbsent(c, 0L);
            map.put(c, map.get(c) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return 0;
    }
}
