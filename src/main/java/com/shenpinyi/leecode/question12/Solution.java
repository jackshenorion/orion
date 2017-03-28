package com.shenpinyi.leecode.question12;

/**
 * Created by jack on 28/03/2017.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        String p1[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int p2[] = {  3000,   2000, 1000, 900, 500, 400,   300,   200, 100,  90,   80,    70,    60,    50,  40,   30,    20,  10};
        String p3[] = {"MMM", "MM", "M", "CM", "D", "CD", "CCC", "CC", "C", "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X"};
        int n = 0;
        int k = num;

        while (n < p2.length) {
            while (k >= p2[n]) {
                k -= p2[n];
                builder.append(p3[n]);
            }
            n++;
        }

        if (k > 0) {
            builder.append(p1[k]);
        }

        return builder.toString();
    }
}
