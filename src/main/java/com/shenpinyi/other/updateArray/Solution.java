package com.shenpinyi.other.updateArray;

import java.util.*;
import java.util.stream.Collectors;

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


    public Map<String, Map<String, String>> pick(Map<String, Map<String, String>> dic, String[] sids) {
        Set<String> set = Arrays.stream(sids).collect(Collectors.toSet());
        return dic.entrySet().stream()
                .filter(entry -> set.contains(entry.getValue().get("sid")))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }
}
