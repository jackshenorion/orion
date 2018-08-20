package com.shenpinyi.lintcode.arraynumbers.question151;

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] beforeMaxProfits = getBeforeMaxProfits(prices);
        int[] afterMaxProfits = getAfterMaxProfits(prices);
        int maxProfit = Math.max(beforeMaxProfits[prices.length - 1], afterMaxProfits[0]);
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = Math.max(beforeMaxProfits[i] + afterMaxProfits[i+1], maxProfit);
        }
        return maxProfit;
    }

    protected int[] getBeforeMaxProfits(int[] prices) {
        int[] maxProfits = new int[prices.length];
        maxProfits[0] = 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            maxProfits[i] = maxProfit;
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfits;

    }

    protected int[] getAfterMaxProfits(int[] prices) {
        int[] maxProfits = new int[prices.length];
        maxProfits[prices.length - 1] = 0;
        int maxProfit = 0;
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxProfits[i] = maxProfit;
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return maxProfits;
    }
}
