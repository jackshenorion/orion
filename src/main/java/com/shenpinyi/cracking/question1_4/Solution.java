package com.shenpinyi.cracking.question1_4;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("Tact Coa"));
        System.out.println(new Solution().run("Tact Coao"));
        System.out.println(new Solution().run("Tact Coaob"));
        System.out.println(new Solution().run("Tact Coab"));
    }

    private boolean run(String input) {
        long[] counts = countChars(input);
        return checkCounts(counts);
    }

    private boolean checkCounts(long[] counts) {
        boolean hasOddChar = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0) {
                if (hasOddChar) {
                    return false;
                } else {
                    hasOddChar = true;
                }
            }
        }
        return true;
    }

    private long[] countChars(String input) {
        long[] counts = new long[256];
        initCounts(counts);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(isChar(c)) {
                counts[lower(c)] ++;
            }
        }
        return counts;
    }

    private boolean isChar(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private char lower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - ('A' - 'a'));
        } else {
            return c;
        }
    }

    private void initCounts(long[] counts) {
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }
    }
}
