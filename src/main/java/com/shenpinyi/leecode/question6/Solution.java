package com.shenpinyi.leecode.question6;

/**
 * Created by jack on 29/03/2017.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return "";
        }

        if (numRows == 0) {
            return "";
        } else if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder builder = new StringBuilder(n);
        for (int i = 0; i < numRows; i++) {
            int first = i;
            int offset = numRows + numRows - 2 - i - i;
            while (first < n) {
                builder.append(s.charAt(first));
                if (i != 0 && i != numRows - 1) {
                    int second = first + offset;
                    if (second < n) {
                        builder.append(s.charAt(second));
                    }
                }
                first += numRows + numRows - 2;
            }
        }
        return builder.toString();
    }
}
