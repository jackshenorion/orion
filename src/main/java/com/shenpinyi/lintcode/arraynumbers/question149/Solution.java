package com.shenpinyi.lintcode.arraynumbers.question149;

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] maxPrices = getMaxPrices(prices);
        int maxRevenue = 0;
        for (int i = 0; i < prices.length; i++ ) {
            maxRevenue = Math.max(maxRevenue, maxPrices[i] - prices[i]);
        }
        return maxRevenue;
    }

    protected int[] getMaxPrices(int[] prices) {
        int days = prices.length;
        int[] maxPrices = new int[days];
        maxPrices[days - 1] = 0;
        int maxPrice = 0;
        for (int i = days - 2; i >=0; i--) {
            maxPrice = Math.max(prices[i + 1], maxPrice);
            maxPrices[i] = maxPrice;
        }
        return maxPrices;
    }

    public int maxProfitB(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxRevenue = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++ ) {
            maxRevenue = Math.max(maxRevenue, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxRevenue;
    }
}
