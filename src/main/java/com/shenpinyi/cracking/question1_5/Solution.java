package com.shenpinyi.cracking.question1_5;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("pale", "ple"));
        System.out.println(new Solution().run("pales", "pale"));
        System.out.println(new Solution().run("pale", "bale"));
        System.out.println(new Solution().run("pale", "bake"));
    }

    private boolean run(String a, String b) {
        if (a.length() == b.length()) {
            return checkUpdate(a, b);
        } else if (a.length() - b.length() == 1) {
            return checkInsert(b, a);
        } else if (b.length() - a.length() == 1) {
            return checkInsert(a, b);
        } else {
            return false;
        }
    }

    private boolean checkUpdate(String a, String b) {
        boolean hasDifference = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (hasDifference) {
                    return false;
                }
                hasDifference = true;
            }
        }
        return true;
    }

    private boolean checkInsert(String shorter, String longer) {
        boolean hasDifference = false;
        int j = 0;
        for (int i = 0; i < shorter.length(); i++) {
            j = hasDifference ? i + 1 : i;
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (hasDifference) {
                    return false;
                }
                hasDifference = true;
            }
        }
        return true;
    }
}
