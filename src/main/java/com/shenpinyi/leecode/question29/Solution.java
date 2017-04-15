package com.shenpinyi.leecode.question29;

/**
 * Created by jack on 15/04/2017.
 */
public class Solution {

    /**
     * 这道题使用移位操作代替乘法
     * 另外,提供了一个思路,如果涉及到Integer可能溢出的情况,则使用long类型先计算,然后再判断溢出
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) { return Integer.MAX_VALUE; }
        if (dividend == 0) { return 0; }
        long longDividend = dividend;
        long longDivisor = divisor;
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);
        long output = roughDivide(longDividend, longDivisor);
        if (isNegative) {
            output = - output;
            if (output < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) output;
            }
        } else {
            if (output > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) output;
            }
        }
    }

    private long roughDivide(long dividend, long divisor) {
        long output = 1;
        long cumDivisor = divisor;
        if (cumDivisor > dividend) {return 0;}
        while(cumDivisor <= dividend) {
            cumDivisor = cumDivisor << 1;
            output = output << 1;
        }
        return (output >> 1) + roughDivide(dividend - (cumDivisor >> 1), divisor);
    }

    public int divide_timeout(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend > 0 && divisor > 0) {
            int res = 0;
            while (dividend >= divisor) {
                dividend -= divisor;
                res++;
            }
            return res;
        } else if (dividend > 0 && divisor < 0) {
            int res = 0;
            while (dividend + divisor >= 0) {
                dividend += divisor;
                res--;
            }
            return res;
        } else if (dividend < 0 && divisor > 0) {
            int res = 0;
            while (dividend + divisor <= 0) {
                dividend += divisor;
                res--;
            }
            return res;
        } else {
            int res = 0;
            while (dividend - divisor <= 0) {
                dividend -= divisor;
                if (res == Integer.MAX_VALUE) {
                    return 0;
                }
                res++;
            }
            return res;
        }
    }
}
