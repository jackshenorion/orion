package com.shenpinyi.cracking.question1_2;

public class Solution {


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cba";
        System.out.println(new Solution().run(s1, s2));
        System.out.println(new Solution().run("ABC", "ABBC"));
        System.out.println(new Solution().run("AB", "ABBC"));
    }

    private boolean run(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        long[] stat1 = getStat(s1);
        long[] stat2 = getStat(s2);
        for (int i = 0; i < stat1.length; i++) {
            if (stat1[i] != stat2[i]) {
                return false;
            }
        }
        return true;
    }

    private long[] getStat(String s) {
        long[] stat = new long[256];
        for (int i = 0; i < stat.length; i++) {
            stat[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            stat[s.charAt(i)]++;
        }
        return stat;
    }
}
