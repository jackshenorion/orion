package com.shenpinyi.leecode.question14;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {
    /**
     * 这个题目也是非常直接的。主要技巧还是在于尽可能减少处理。比如如果一个字符串,那么就直接返回。
     * 另外,先花点找到最小长度字符串,那么就减少了后续代码中判断是否长度超过当前字符串长度的判断。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        } else if (len == 1) {
            return strs[0];
        }

        int[] lengths = new int[len];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int current = strs[i].length();
            lengths[i] = current;
            minLen = Math.min(current, minLen);
        }

        char[] prefix = new char[minLen];
        int seq = 0;
        while (seq < minLen) {
            char c = strs[0].charAt(seq);
            boolean isBreak = false;
            for (int i = 1; i < len; i++) {
                if (strs[i].charAt(seq) != c) { isBreak = true; break; }
            }
            if (isBreak) {break;}
            prefix[seq] = c;
            seq ++;
        }

        return new String(prefix, 0, seq);
    }
}
