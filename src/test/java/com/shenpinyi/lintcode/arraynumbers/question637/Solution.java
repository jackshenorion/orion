package com.shenpinyi.lintcode.arraynumbers.question637;

public class Solution {

    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (!isNumber(c)) {
                if (!number.toString().isEmpty()) {
                    index += Long.valueOf(number.toString());
                    number.setLength(0);
                }
                if (index >= word.length() || c != word.charAt(index)) {
                    return false;
                }
                index++;
            } else {
                number.append(c);
                if (number.charAt(0) == '0') {
                    return false;
                }
            }
        }
        if (!number.toString().isEmpty()) {
            index += Long.valueOf(number.toString());
        }
        return index == word.length();

    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
