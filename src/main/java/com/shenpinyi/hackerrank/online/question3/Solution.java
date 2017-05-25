package com.shenpinyi.hackerrank.online.question3;

/**
 * Created by jack on 2/05/2017.
 */
public class Solution {
    static int IPaddresses(String input) {
        return getPermutations(input, 4);
    }

    static boolean checkNumber(String number) {
        int n = Integer.valueOf(number);
        return n >= 0 && n <= 255;
    }

    static int getPermutations(String s, int segments) {

        if (segments == 1) {
            return checkNumber(s) ? 1 : 0;
        }

        int count = 0;
        for (int i = 0; i < 3 && i < s.length(); i ++) {
            String current = s.substring(0, i + 1);
            String rest = s.substring(i + 1);
            if (checkNumber(current)) {
                count += getPermutations(rest, segments - 1);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(IPaddresses("155315627"));
    }
}
