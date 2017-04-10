package com.shenpinyi.leecode.question372;

import java.util.Arrays;

/**
 * Created by jack on 5/04/2017.
 */
public class Solution {
    public int superPow(int a, int[] b) {

        int n = 1337;
        a = a % n;
        int[] base = new int[10];
        base[0] = 1;
        for (int i = 1; i < 10; i ++) {
            base[i] = (base[i - 1] * a)  % n;
        }

        int result = 1;
        for (int i = 0; i < b.length; i ++ ) {
            int pre = result;
            for (int j = 1; j < 10; j ++) {
                result = (result * pre) % n;
            }
            result = (result * base[b[i]]) % n;
        }

        return result;
    }
}
