package com.shenpinyi.lintcode.arraynumbers.question144;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rerange() {

        int[] nums = {-1, -2, -3, 4, 5, 6};
        new Solution().rerange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    @Test
    public void rerangeB() {

        int[] nums = {28,2,-22,-27,2,9,-33,-4,-18,26,25,34,-35,-17,2,-2,32,35,-8};
        new Solution().rerange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}