package com.shenpinyi.cracking.bit.question5_2;

public class Solution {

    public String printBinary(double num) {

        StringBuilder sb = new StringBuilder();
        final int MAX_LEN = 32;
        double rest = num;
        for(int i = 0; i < MAX_LEN; i ++) {
            rest *= 2;
            if (rest >= 1) {
                sb.append("1");
                rest --;
            } else {
                sb.append("0");
            }
            if (rest == 0) {
                break;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().printBinary(0.72));
        System.out.println(new Solution().printBinary(0.5));
        System.out.println(new Solution().printBinary(0.625));
    }
}
