package com.shenpinyi.leecode.question357;

/**
 * Created by jack on 15/04/2017.
 */
public class Solution {

    /**
     * 这个题目只要具备简单的排列组合知识就可以做出来,不需要特别的技巧
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            n = 10;
        }
        int sum = 0;
        for (int m = 0; m <= n; m++) {
            int subSum = 9;
            if (m == 0) {
                subSum = 1;
            } else {
                for (int i = 1; i < m; i ++) {
                    subSum *= 10 - i;
                }
            }
            sum += subSum;
        }
        return sum;
    }

}
