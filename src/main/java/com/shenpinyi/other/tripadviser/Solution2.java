package com.shenpinyi.other.tripadviser;

import java.util.*;

public class Solution2 {

    static String[] braces(String[] values) {
        if (values == null) {
            return null;
        }
        String[] result = new String[values.length];
        Set<Character> braces = getBraces();
        Map<Character, Character> pairs = getBracesPairs();
        for (int i = 0; i < values.length; i++) {
            result[i] = isValidBraces(values[i], braces, pairs) ? "YES" : "NO";
        }
        return result;
    }

    private static Set<Character> getBraces() {
        return new HashSet<>(Arrays.asList('(', ')', ']', '[', '}', '{'));
    }

    private static Map<Character, Character> getBracesPairs() {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        return pairs;
    }

    private static boolean isValidBraces(String s, Set<Character> braces, Map<Character, Character> pairs) {
        if (s == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!braces.contains(c)) {
                continue; // normal char
            }
            if (!pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pair = pairs.get(c);
                if (stack.pop() != pair) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
