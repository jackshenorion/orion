package com.shenpinyi.hackerrank.online.question4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2/05/2017.
 */
public class Solution {

    static int substrings(String input) {
        String s = removeSpace(input);
        Map<String, Integer> frequency = getFrequency(s);
        return count(frequency);
    }

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    static Map<String, Integer> getFrequency(String input) {
        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < input.length() - 3; i ++) {
            String segment = input.substring(i, i + 4);
            Integer count = frequency.get(segment);
            if (count == null) {
                frequency.put(segment, 1);
            } else {
                frequency.put(segment, count + 1);
            }
        }
        return frequency;
    }


    static int count(Map<String, Integer> frequency) {
        int count = 0;
        for (String s : frequency.keySet()) {
            if (frequency.get(s) > 1) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(substrings("three lions and three lionesses"));

    }


}
