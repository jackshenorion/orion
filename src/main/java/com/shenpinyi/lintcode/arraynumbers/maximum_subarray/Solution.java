package com.shenpinyi.lintcode.arraynumbers.maximum_subarray;

/**
 * Created by jack on 11/06/2017.
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int smallestSum = 0;
        int currentSum = 0;
        int maxSubSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (i == 0) {
                maxSubSum = nums[0];
            } else {
                maxSubSum = Math.max(maxSubSum, currentSum - smallestSum);
            }
            smallestSum = Math.min(smallestSum, currentSum);
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(
            new int[]{-2,2,-3,4,-1,2,1,-5,3}
        ));

        System.out.println(new Solution().maxSubArray(
            new int[]{-3,-2}
        ));

        System.out.println(new Solution().maxSubArray(
            new int[]{1,2,3,4,5,6,7,100,200,1000}
        ));

        System.out.println(new Solution().maxSubArray(
            new int[]{1}
        ));

        System.out.println(new Solution().maxSubArray(
            new int[]{-1}
        ));

        System.out.println(new Solution().maxSubArray(
            new int[]{-1,-2,-3,-100,-1,-50}
        ));
    }

}
