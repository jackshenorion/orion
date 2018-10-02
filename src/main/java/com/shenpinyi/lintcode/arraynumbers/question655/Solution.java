package com.shenpinyi.lintcode.arraynumbers.question655;

import java.util.Arrays;

public class Solution {

    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2) + 1;
        char[] result = new char[maxLen];
        int carry = 0;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int index1 = len1 - 1 - i;
            int index2 = len2 - 1 - i;
            int index = maxLen - 1 - i;
            int sum = carry;
            if (index1 >= 0) {
                sum += num1.charAt(index1) - '0';
            }
            if (index2 >= 0) {
                sum += num2.charAt(index2) - '0';
            }
            result[index] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }
    public String addStringsB(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2) + 1;
        char[] result = new char[maxLen];
        int carry = 0;
        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int index = maxLen - 1;
        while (index1 >= 0 || index2 >= 0) {
            int sum = carry;
            if (index1 >= 0) {
                sum += num1.charAt(index1) - '0';
            }
            if (index2 >= 0) {
                sum += num2.charAt(index2) - '0';
            }
            result[index] = (char) (sum % 10 + '0');
            carry = sum / 10;
            index1--;
            index2--;
            index--;
        }
        if (carry > 0) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }
}
