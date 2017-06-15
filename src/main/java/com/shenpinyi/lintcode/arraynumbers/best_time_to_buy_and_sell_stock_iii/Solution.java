package com.shenpinyi.lintcode.arraynumbers.best_time_to_buy_and_sell_stock_iii;

import java.util.PriorityQueue;

/**
 * Created by jack on 12/06/2017.
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int[] left = calcMaxProfitFromLeft(prices);
        int[] right = calcMaxProfitFromRight(prices);

        int maxProfit = left[len - 1];
        for (int i = 0; i < len - 2; i ++) {
            maxProfit = Math.max(left[i] + right[i + 1], maxProfit);
        }
        return maxProfit;
    }

    private int[] calcMaxProfitFromLeft(int[] prices) {
        int[] maxProfits = new int[prices.length];
        int lowestPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            maxProfit = Math.max(maxProfit, price - lowestPrice);
            maxProfits[i] = maxProfit;
            lowestPrice = Math.min(price, lowestPrice);
        }
        return maxProfits;
    }

    private int[] calcMaxProfitFromRight(int[] prices) {
        int[] maxProfits = new int[prices.length];
        int hightestPrice = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            int price = prices[i];
            maxProfit = Math.max(maxProfit, hightestPrice - price);
            maxProfits[i] = maxProfit;
            hightestPrice = Math.max(price, hightestPrice);
        }
        return maxProfits;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(
            new int[]{4,4,6,1,1,4,2,5}
        ));

        System.out.println(new Solution().maxProfit(
            new int[]{1,2,4,2,5,7,2,4,9,0}
        ));

        System.out.println(new Solution().maxProfit(
            new int[]{1,2}
        ));

    }

}
