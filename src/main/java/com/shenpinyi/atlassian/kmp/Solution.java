package com.shenpinyi.atlassian.kmp;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }

    public int run(String text, String word) {
        int[] t = getT(word);
        int m = getFirstMatch(text, word, t);
        return m;
    }

    private int getFirstMatch(String text, String word, int[] t) {
        // lengthOfWord
        // from the first index of text until the end textPosition
        // textPosition
        // keep comparing the nth char for 0 to lengthOfWord - 1 : wordPosition
        // if until the last one is the same, return startPosition/ checkingPosition - lengthOfWord + 1
        // if it's not equal, then decide what's the next startPosition
        // how to decide the next startPosition
        // alreadyMatched = t[checkingPosition]
        // so we start checking from checkingPosition
        int wordPosition = 0;
        int lengthOfWord = word.length();
        for (int textPosition = 0; textPosition < text.length(); textPosition++) {
            char textChar = text.charAt(textPosition);
            char wordChar = word.charAt(wordPosition);
            if (textChar == wordChar) {
                if (wordPosition == lengthOfWord - 1) {
                    return textPosition - lengthOfWord + 1;
                } else {
                    wordPosition++;
                }
            } else {
                int alreadyMatched = t[wordPosition];
                wordPosition = alreadyMatched;
            }
        }
        return -1;
    }

    public int[] getT(String w) {
        int[] t = new int[w.length()];
        // for each length of prefix of w
        // get the longest matched prefix and suffix
        for (int i = 0; i < w.length(); i++) {
            t[i] = getLongestMatch(w, i);
        }
        return t;
    }

    private int getLongestMatch(String w, int segmentLength) {
        // segmentLength is the length has been matched
        // if len is 1, then the result is 0
        // if len > 1, then from prefix/suffix = len - 1 to 1, check whether they're same
        if (segmentLength == 1) {
            return 0;
        }
        for (int prefixLength = segmentLength - 1; prefixLength > 0; prefixLength--) {
            boolean isMatch = true;
            // i is the length to check
            int firstPrefixIdx = 0;
            int lastPrefixIdx = prefixLength - 1;
            int lastSuffixIdx = segmentLength - 1;
            int suffixIdx = segmentLength - prefixLength;

            for (int i = 0; i <= lastPrefixIdx; i++) {
                char preChar = w.charAt(i);
                char sufChar = w.charAt(suffixIdx + i);
                if (preChar != sufChar) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return prefixLength;
            }
        }
        return 0;
    }


}
