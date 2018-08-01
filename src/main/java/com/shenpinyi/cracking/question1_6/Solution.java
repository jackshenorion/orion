package com.shenpinyi.cracking.question1_6;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("a"));
        System.out.println(new Solution().run("aabcccccaaa"));
        System.out.println(new Solution().run("aabcacbcada"));
    }

    private String run(String input) {
        if (input.length() <= 1) {
            return input;
        }
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int current = 1; current < input.length(); current++) {
            if (input.charAt(current) != input.charAt(start)) {
                sb.append(input.charAt(start) + "" + (current - start));
                start = current;
            }
        }
        sb.append(input.charAt(start) + "" + (input.length() - start));
        return sb.length() >= input.length() ? input : sb.toString();
    }

}
