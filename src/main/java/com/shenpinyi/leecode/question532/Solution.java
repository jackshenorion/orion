package com.shenpinyi.leecode.question532;

import java.util.Arrays;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {

    /**
     * 击败了94.5%的提交
     * 关键点在于第二次遍历没有用二分查询。而是采用线性搜索的方式。
     * 另外在大数到结尾的时候跳出处理,而非小数一直循环到最后。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        if (k < 0) {
            return 0;
        } else if (k == 0) {
            int last = Integer.MIN_VALUE;
            boolean isRepeat = false;
            for (int i = 0; i < len; i ++) {
                int current = nums[i];
                if (last == Integer.MIN_VALUE || current != last) { // new number
                    if (isRepeat) {
                        count ++;
                    }
                    isRepeat = false;
                    last = current;
                } else {
                    isRepeat = true;
                }
            }
            if (isRepeat) {
                count ++;
            }
        } else {
            int last = Integer.MIN_VALUE;
            int j = 1;
            for (int i = 0; i < len; i ++) {
                int current = nums[i];
                if (current == last) { // repeat number
                    continue;
                } else {
                    last = current;
                }
                int target = current + k;
                boolean isFind = false;
                while (j < len) {
                    int pair = nums[j];
                    if (pair > target) {
                        break;
                    }

                    if (pair == target){
                        isFind = true;
                    }
                    j ++;
                }
                if (isFind) {
                    count ++;
                }
                if (j >= len) {
                    break;
                }
            }
        }

        return count;
    }
}
