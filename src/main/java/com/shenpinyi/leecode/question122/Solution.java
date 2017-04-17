package com.shenpinyi.leecode.question122;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {

    /**
     * 这道题属于股票买卖里面比较简单的,因为限制比较少。因此,仅仅考察寻找一个序列中连续下降和连续上升的端点。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int i = 0;
        int len = prices.length;
        while (i < len) {
            int min = i;
            while (min + 1 < len && prices[min + 1] <= prices[min]) { min++; }
            int max = min + 1;
            if (max > len - 1) { break; }
            while (max + 1 < len && prices[max + 1] > prices[max]) { max++; }
            sum += prices[max] - prices[min];
            i = max + 1;
        }
        return sum;
    }
}
