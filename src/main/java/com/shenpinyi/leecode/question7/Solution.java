package com.shenpinyi.leecode.question7;

import java.util.Collections;

/**
 * Created by jack on 15/04/2017.
 */
public class Solution {

    /**
     * 这个是第一个解法,运行时间打败了62%-92%不等的提交。
     * 个人觉得为什么比下面其它快,是因为没有使用字符串操作,仅仅使用加减乘除,和int数组
     * 这个告诉我们,算数运算,即便是除法和取模这样的操作,也比字符串操作快。
     * 另外,貌似在其它运算相同的情况下,条件判断越多,性能越低
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isPositive = x >= 0;
        int y = Math.abs(x);
        int[] reversed = new int[10];
        int count = 0;
        while (y > 0) {
            int rest = y / 10;
            int mod = y % 10;
            reversed[count++] = mod;
            y = rest;
        }

        int output = 0;
        if (count == 10 && reversed[0] > 2) {
            return 0;
        }
        for (int i = 0; i < count; i ++) {
            output = reversed[i] + output * 10;
        }
        if (output < 0) {return 0;}
        return isPositive ? output : - output;
    }

    public int reverse_25(int x) {
        boolean isPositive = x >= 0;
        int y = Math.abs(x);
        int count = 0;
        int high = 0;
        int output = 0;
        while (y > 0) {
            int rest = y / 10;
            int mod = y % 10;
            if (count == 0) {
                high = mod;
            }
            count ++;
            if (count == 10 && high > 2) {
                return 0;
            }
            output = mod + output * 10;
            y = rest;
        }

        if (output < 0) {return 0;}
        return isPositive ? output : - output;
    }

    public int reverse_38(int x) {
        boolean isPositive = x >= 0;
        int y = Math.abs(x);
        String yString = new StringBuilder(Integer.toString(y)).reverse().toString();
        int output;
        try {
            output = Integer.valueOf(yString);
        } catch (Exception e) {
            return 0;
        }
        return isPositive ? output : - output;
    }

    public int reverse_50(int x) {
        boolean isPositive = x >= 0;
        int y = Math.abs(x);
        String yString = Integer.toString(y);

        int count = yString.length();
        int output = 0;
        if (count == 10 && yString.charAt(count - 1) - '0'> 2) {
            return 0;
        }

        for (int i = 0; i < count; i ++) {
            output = yString.charAt(count - i - 1) - '0' + output * 10;
        }
        if (output < 0) {return 0;}
        return isPositive ? output : - output;
    }

}
