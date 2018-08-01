package com.shenpinyi.cracking.question1_9;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("waterbottle", "erbottlewat"));
        System.out.println(new Solution().run("waterbottle", "erbottlewta"));
    }

    private boolean run(String a, String b) {
        return (a + a).contains(b);
    }
}
