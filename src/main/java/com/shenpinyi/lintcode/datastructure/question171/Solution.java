package com.shenpinyi.lintcode.datastructure.question171;

import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = getKey(strs[i]);
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(strs[i]);
        }
        List<String> result = new ArrayList();
        for (String key : strMap.keySet()) {
            if (strMap.get(key).size() > 1) {
                result.addAll(strMap.get(key));
            }
        }
        return result;
    }
    private String getKey(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }

}
