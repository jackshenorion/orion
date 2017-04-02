package com.shenpinyi.leecode.question424;

/**
 * Created by jack on 1/04/2017.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] f = new int[26];
        int max = 0, len = s.length(), start = 0, end = 0, count = 0;
        while (end < len) {
            count = ++ f[s.charAt(end++) - 'A'];
            max = count > max ? count : max;
            if (max + k < end - start) {
                f[s.charAt(start++) - 'A']--;
            }
        }
        return max + k > len ? len : max + k;
    }


    public int characterReplacement1(String s, int k) {
        if (s == null) {
            return 0;
        }
        int p = 0;
        int len = s.length();
        int max = 0;
        while (p < len) {
            char c = s.charAt(p);
            int u = k;
            int j = p + 1;
            int count = 1;
            int next = p + 1;
            boolean isNextSet = false;
            while (j < len) {
                if (s.charAt(j) == c) {
                    count ++;
                } else if (u == 0){
                    if (!isNextSet) {
                        next = j;
                        isNextSet = true;
                    }
                    break;
                } else {
                    if (!isNextSet) {
                        next = j;
                        isNextSet = true;
                    }
                    count ++;
                    u --;
                }
                j ++;
            }
            p = next;
            count += u;
            max = count > max ? count : max;
        }

        return max > len ? len : max;
    }
}
