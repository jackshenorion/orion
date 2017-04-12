package com.shenpinyi.leecode.question322;

import java.util.Arrays;

/**
 * Created by jack on 11/04/2017.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return change(coins, coins.length - 1, amount, amount / coins[0] + 1);
    }

    private int change(int[] coins, int offset, int amount, int maxCount) {
        int currentCoin = coins[offset];
        int count = 0;
        int sum = amount;
        boolean hasResult = false;
        while (sum >= currentCoin) {
            count ++;
            sum -= currentCoin;
        }

        if (count > maxCount) {
            return -1;
        }

        if (sum == 0) {
            return count;
        }

        if (offset == 0) {
            return -1;
        }

        int smallerCoin = coins[offset - 1];

        while (count >= 0) {
            if (count * currentCoin + smallerCoin * (maxCount - count) < amount) {
                break;
            }

            int restCount = change(coins, offset - 1, sum, maxCount - count);
            if (restCount != -1) {
                maxCount = Math.min(maxCount, count + restCount);
                hasResult = true;
            }
            count --;
            sum += currentCoin;
        }

        if (hasResult) {
            return maxCount;
        } else {
            return -1;
        }

    }
}
