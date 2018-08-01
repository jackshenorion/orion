package com.shenpinyi.cracking.question1_1;

public class Solution {


    public boolean check(String input) {
        boolean[] c = new boolean[256];
        for (char i = 0; i < c.length; i++) {
            c[i] = false;
        }
        for (int i = 0; i < input.length(); i++) {
            c[input.charAt(i)] = true;
        }
        for (char i = 0; i < c.length; i++) {
            if (isChar(i) && c[i] == false) {
                return false;
            }
        }
        return true;
    }

    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
