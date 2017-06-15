package com.shenpinyi.lintcode.arraynumbers.best_time_to_buy_and_sell_stock;

/**
 * Created by jack on 11/06/2017.
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            int currentPrice = prices[i];
            lowestPrice = Math.min(lowestPrice, prices[i]);
            maxProfit = Math.max(maxProfit, currentPrice - lowestPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(
            new int[]{3,2,3,1,2}
        ));
    }

}
