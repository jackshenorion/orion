package com.shenpinyi.lintcode.arraynumbers.best_time_to_buy_and_sell_stock_ii;

/**
 * Created by jack on 12/06/2017.
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int last = Integer.MAX_VALUE;
        int totalProfit = 0;

        for (int price : prices) {
            totalProfit += price > last ? price - last : 0;
            last = price;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(
            new int[]{2, 1, 2, 0, 1, 3}
        ));
    }

}
