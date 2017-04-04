package com.shenpinyi.leecode.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 3/04/2017.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        set.add(new ArrayList<>());
        if (nums == null || nums.length == 0){
            return set;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            int k = set.size();
            for (int j = 0; j < k; j ++) {
                List<Integer> n = new ArrayList<>(set.get(j));
                n.add(x);
                set.add(n);
            }
        }
        return set;
    }
}
