package com.shenpinyi.other.codility.question3;

/**
 * Created by jack on 30/05/2017.
 */
public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String NOTHING = "NOTHING";
    private static final String SWAP = "SWAP";
    private static final String DELETE = "DELETE";
    private static final String INSERT = "INSERT";

    public String solution(String S, String T) {
        return check(S, T);
    }

    public static String check(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS == lengthT) {
            return checkSameLength(s, t);
        } else if (lengthS + 1 == lengthT || lengthS == lengthT + 1) {
            return checkDiffLength(s, t);
        } else {
            return IMPOSSIBLE;
        }
    }

    public static String checkSameLength(String s, String t) {
        int len = s.length();
        int count = 0;
        char[] diffS = new char[2];
        char[] diffT = new char[2];
        for (int i = 0; i < len; i ++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (charS == charT) {
                continue;
            } else {
                count ++;
                if (count == 1) {
                    diffS[0] = charS;
                    diffT[0] = charT;
                } else if (count == 2) {
                    diffS[1] = charS;
                    diffT[1] = charT;
                }
            }
        }

        if (count == 0) {
            return NOTHING;
        } else if (count != 2) {
            return IMPOSSIBLE;
        } else if (diffS[0] == diffT[1] && diffS[1] == diffT[0]) {
            return SWAP + " " + diffS[0] + " " + diffS[1];
        }
        return IMPOSSIBLE;
    }

    public static String checkDiffLength(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS < lengthT) {
            return checkInsertOrDelete(INSERT, s, t);
        } else {
            return checkInsertOrDelete(DELETE, t, s);
        }
    }

    public static String checkInsertOrDelete(String insertOrDelete, String shorter, String longer) {
        int diffCount = 0;
        int i = 0;
        int j = 0;
        char insert = ' ';
        while (i < shorter.length()) {
            char charS = shorter.charAt(i);
            char charT = longer.charAt(j);

            if (charS == charT) {
                i ++;
                j ++;
                continue;
            }

            if (diffCount == 0) {
                diffCount ++;
                insert = charT;
                j ++;
            } else {
                return IMPOSSIBLE;
            }
        }

        if (diffCount == 0) {
            return insertOrDelete + " " + longer.charAt(longer.length() - 1);
        } else {
            return insertOrDelete + " " + insert;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new Solution().
                solution("nice", "niece")
        );
        System.out.println(
            new Solution().
                solution("nice", "niecew")
        );
        System.out.println(
            new Solution().
                solution("niece", "nice")
        );
        System.out.println(
            new Solution().
                solution("nice", "nice")
        );
        System.out.println(
            new Solution().
                solution("nice", "nicee")
        );
        System.out.println(
            new Solution().
                solution("nice", "niec")
        );
        System.out.println(
            new Solution().
                solution("ince", "nice")
        );
        System.out.println(
            new Solution().
                solution("ice", "nice")
        );
        System.out.println(
            new Solution().
                solution("nice", "ice")
        );
        System.out.println(
            new Solution().
                solution("", "")
        );
        System.out.println(
            new Solution().
                solution("a", "b")
        );
    }

}
