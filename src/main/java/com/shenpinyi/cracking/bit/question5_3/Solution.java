package com.shenpinyi.cracking.bit.question5_3;

public class Solution {

    public int longestSequence(int num) {

        int lastOnes = 0;
        int lastZeros = 0;
        int thisOnes = 0;
        int thisZeros = 0;
        int maxLen = 0;
        for (int i = 0; i < 32; i++) {
            boolean isOne = (num & (1 << i)) != 0;
            if (isOne) {
                thisOnes++;
                if (thisZeros != 0) { // from 0 to one
                    lastZeros = thisZeros;
                    thisZeros = 0;
                }
                if (lastZeros == 1) { // can connect last ones
                    maxLen = Math.max(thisOnes + lastZeros + lastOnes, maxLen);
                } else if (lastZeros > 1) { // can't connect last ones
                    maxLen = Math.max(thisOnes + 1, maxLen);
                } else { // no last zeros, means at the beginning and all 1s
                    maxLen = Math.max(thisOnes, maxLen);
                }
            } else {
                thisZeros++;
                lastZeros = 0;
                if (thisZeros == 1) { // can connect to last ones
                    lastOnes = thisOnes;
                    thisOnes = 0;
                    maxLen = Math.max(lastOnes + 1, maxLen);
                } else { // reinitialize
                    lastOnes = 0;
                    thisOnes = 0;
                }
            }

        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestSequence(0b11011101111));//8
        System.out.println(new Solution().longestSequence(0b0)); //1
        System.out.println(new Solution().longestSequence(0b1)); //2
        System.out.println(new Solution().longestSequence(0b1010101010));//3
        System.out.println(new Solution().longestSequence(0b10101010101));//3
        System.out.println(new Solution().longestSequence(~0));//32
        System.out.println(new Solution().longestSequence(~0 << 31));//2
    }
}
