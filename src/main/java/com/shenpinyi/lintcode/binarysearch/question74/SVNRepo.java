package com.shenpinyi.lintcode.binarysearch.question74;

public class SVNRepo {
    public static boolean isBadVersion(int v) {
        boolean[] states = {false, false, false, false, true, true};
        return states[v - 1];
    }

}
