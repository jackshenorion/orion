package com.shenpinyi.leecode.question8;

/**
 * Created by jack on 30/03/2017.
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int len = str.length();
        boolean isPositive = true;
        int count = 0;
        int k = 0;
        double result = 0;

        while (k < len && str.charAt(k) == ' ') {
            k++;
        }

        if (k == len) {
            return 0;
        }

        char c2 = str.charAt(k);
        if (c2 == '+') {
            isPositive = true;
            k ++;
        } else if (c2 == '-') {
            isPositive = false;
            k ++;
        }

        while (k < len && str.charAt(k) == '0') {
            k ++;
        }

        if (k == len) {
            return 0;
        }

        while (k < len) {
            char c = str.charAt(k++);
            if ((c >= '0' && c <= '9')) {
                if (count == 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    result = result * 10 + c - '0';
                    count ++;
                }
            } else {
                break;
            }
        }

        result = isPositive ? result : - result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if ( result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)result;
        }
    }
}
