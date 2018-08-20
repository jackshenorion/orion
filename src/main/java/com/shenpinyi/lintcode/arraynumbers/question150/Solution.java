package com.shenpinyi.lintcode.arraynumbers.question150;

public class Solution {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int beginIdx = 0;
        int sumProfit = 0;
        for (int i = 1; i < prices.length; i ++) {
            int currentPrice = prices[i];
            int lastPrice = prices[i - 1];
            if (currentPrice < lastPrice) {
                int lastIdx = i - 1;
                if (lastIdx > beginIdx) {
                    sumProfit += prices[lastIdx] - prices[beginIdx];
                }
                beginIdx = i;
            }
        }
        if (beginIdx < prices.length - 1) {
            sumProfit += prices[prices.length - 1] - prices[beginIdx];
        }
        return sumProfit;
    }
}
