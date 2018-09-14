package com.shenpinyi.lintcode.dp.question118;

public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if ((S == null || S.length() == 0) && (T == null || T.length() == 0)) {
            return 1;
        } else if ((S == null || S.length() == 0) || (T == null || T.length() == 0)) {
            return 1;
        }

        String longer = S.length() >= T.length() ? S : T;
        String shorter = longer == S ? T : S;
        int len1 = longer.length();
        int len2 = shorter.length();
        int[][] nums = new int[len1 + 1][len2 + 1];
        nums[0][0] = 1;
        for (int i = 1; i < len1 + 1; i++) { // j is 0
            nums[i][0] = 1;
        }
        for (int j = 1; j < len2 + 1; j++) { // i is 0
            nums[0][j] = 0;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char l = longer.charAt(i - 1);
                char s = shorter.charAt(j - 1);
                if (l != s) { // have no choice but delete from l
                    nums[i][j] = nums[i - 1][j];
                } else {
                    nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
                }
            }
        }
        return nums[len1][len2];
    }
}
