package com.shenpinyi.lintcode.arraynumbers.question49;

public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length <= 1) {
            return;
        }
        int lower = 0;
        int higher = chars.length - 1;
        while (lower < higher) {
            while (lower < higher && chars[lower] <= 'z' && chars[lower] >= 'a') {
                lower++;
            }
            while (lower < higher && chars[higher] >= 'A' && chars[higher] <= 'Z') {
                higher--;
            }
            char temp = chars[lower];
            chars[lower] = chars[higher];
            chars[higher] = temp;
        }
    }
}
