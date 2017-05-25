package com.shenpinyi.hackerrank.strings.SherlockAndTheValidString;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String s){
        // Complete this function
        int[] f = getFrequency(s);
        Map statics = getStatics(f);
        return checkStatics(statics) ? "YES" : "NO";
    }

    static int[] getFrequency(String s) {
        int[] f = new int[128];
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)] ++;
        }
        return f;
    }

    static Map<Integer, Integer> getStatics(int[] frequency) {
        Map<Integer, Integer> statics = new HashMap<>();
        for (int count : frequency) {
            increaseStatics(statics, count);
        }
        return statics;
    }

    static void increaseStatics(Map<Integer, Integer> statics, int count) {
        if (count == 0) {
            return;
        }
        if (statics.get(count) == null) {
            statics.put(count, 1);
        } else {
            statics.put(count, statics.get(count) + 1);
        }
    }

    static boolean checkStatics(Map<Integer, Integer> statics) {
        return checkSame(statics) || checkOnlyOneAlone(statics) || checkOnlyOneDiff(statics);
    }

    static boolean checkSame(Map<Integer, Integer> statics) {
        return statics.size() == 1 || statics.size() == 0;
    }

    static boolean checkOnlyOneAlone(Map<Integer, Integer> statics) {
        if (statics.size() != 2) {
            return false;
        }

        for (Integer count : statics.keySet()) {
            if (count == 1 && statics.get(count) == 1) {
                return true;
            }
        }
        return false;
    }

    static boolean checkOnlyOneDiff(Map<Integer, Integer> statics) {
        if (statics.size() != 2) {
            return false;
        }
        Map.Entry<Integer, Integer> firstEntry = null;
        for (Map.Entry<Integer, Integer> entry : statics.entrySet()) {
            if (firstEntry == null) {
                firstEntry = entry;
            } else {
                if (Math.abs(entry.getKey() - firstEntry.getKey()) == 1 // the frequency only has 1 diff
                    && (entry.getValue() == 1 || firstEntry.getValue() == 1)) { // only one char is diff
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
