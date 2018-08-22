package com.shenpinyi.other.updateArray;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public void updateArray(String[][] a, String[][] b) {
        Map<String, Map<String, String[]>> bMap = new HashMap<>();
        for (String[] item : b) {
            bMap.putIfAbsent(item[0], new HashMap<>());
            bMap.get(item[0]).put(item[1], item);
        }
        for (int i = 0; i < a.length; i++) {
            String key1 = a[i][0];
            String key2 = a[i][1];
            String[] value = (String[]) bMap.getOrDefault(key1, Collections.EMPTY_MAP).get(key2);
            if (value != null) {
                a[i] = value;
            }
        }
    }
}
