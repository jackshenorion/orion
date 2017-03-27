package com.shenpinyi.leecode.question383;

/**
 * Created by jack on 26/03/2017.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] note = new char[256];
        for (int i = 0; i < ransomNote.length(); i++) {
            note[ransomNote.charAt(i)] ++;
        }

        int left = ransomNote.length();
        int current = 0;
        while (left > 0 && current < magazine.length()) {
            if (note[magazine.charAt(current)] > 0) {
                note[magazine.charAt(current)] --;
                left--;
            }
            current ++;
        }

        return left == 0;
    }
}
