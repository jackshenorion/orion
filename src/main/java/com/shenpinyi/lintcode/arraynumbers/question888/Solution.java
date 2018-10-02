package com.shenpinyi.lintcode.arraynumbers.question888;

public class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        if (words == null) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (isEmpty(words, j, i)) {
                    return false;
                }
                if (words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEmpty(String[] words, int i, int j) {
        if (i > words.length - 1) {
            return true;
        }
        if (j > words[i].length() - 1) {
            return true;
        }
        return false;
    }

}
