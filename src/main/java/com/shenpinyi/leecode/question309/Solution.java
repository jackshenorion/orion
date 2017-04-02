package com.shenpinyi.leecode.question309;

/**
 * Created by jack on 2/04/2017.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int preSell = 0, buy = 0, sell = 0, preBuy = 0;
        if (len == 1) {
            return 0;
        }

        if (len >= 2) {
            preSell = 0;
            sell = (prices[1] - prices[0]) > 0 ? (prices[1] - prices[0]) : 0;
            buy = prices[1] > prices[0] ? -prices[0] : - prices[1];
        }

        int k = 2;
        while (k < len) {
            preBuy = buy;
            buy = Math.max(buy, - prices[k] + preSell);
            preSell = sell;
            sell = Math.max(preSell, prices[k] + preBuy);
            k ++;
        }

        return sell;
    }
}
