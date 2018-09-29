package com.shenpinyi.lintcode.arraynumbers.question407;

import java.util.Arrays;

public class Solution {

    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {

        int carry = 1;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            int newCurrent = current + carry;
            result[i] = newCurrent % 10;
            carry = newCurrent / 10;
        }
        if (carry > 0) {
            int[] newResult = new int[digits.length + 1];
            System.arraycopy(result, 0, newResult, 1, result.length);
            newResult[0] = 1;
            return newResult;
        }
        return result;

    }

}
