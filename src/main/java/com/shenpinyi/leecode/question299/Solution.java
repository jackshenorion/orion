package com.shenpinyi.leecode.question299;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] a = new int[10];
        int[] b = new int[10];
        int[] m = new int[10];
        for (int i = 0; i < secret.length(); i ++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            a[s - '0'] ++;
            b[g - '0'] ++;
            if (s == g) {
                m[s - '0'] ++;
            }
        }

        for (int i = 0; i < 10; i ++) {
            bull += m[i];
            cow += Math.min(a[i] - m[i], b[i] - m[i]);
        }
        return bull+"A"+cow+"B";

    }
}
