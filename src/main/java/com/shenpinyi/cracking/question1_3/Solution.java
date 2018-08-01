package com.shenpinyi.cracking.question1_3;

public class Solution {
    public static void main(String[] args) {
        char[] cs = "Mr John Smith       ".toCharArray();
        new Solution().run(cs, 13);
        System.out.println(new String(cs));
    }

    private void run(char[] input, int len) {
        int numberOfSpaces = getNumberOfSpaces(input, len);
        if (numberOfSpaces == 0) {
            return;
        }
        int target = len + numberOfSpaces * 2 - 1;
        for (int i = len - 1; i >= 0; i--) {
            if(input[i] == ' ') {
                input[target] = '0';
                input[target - 1] = '2';
                input[target - 2] = '%';
                target -= 3;
            } else {
                input[target] = input[i];
                target --;
            }
        }
    }

    private int getNumberOfSpaces(char[] input, int len) {
        int numberOfSpaces = 0;
        for (int i = 0; i < len; i ++) {
            if (input[i] == ' ') {
                numberOfSpaces ++;
            }
        }
        return numberOfSpaces;
    }
}
