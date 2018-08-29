package com.shenpinyi.lintcode.binarysearch.question457;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findPosition() {
        int[] nums = {1,2,2,4,5,5};
        int position = new Solution().findPosition(nums, 2);
        assertTrue(position == 1 || position == 2);
        position = new Solution().findPosition(nums, 5);
        assertTrue(position == 4 || position == 5);
        position = new Solution().findPosition(nums, 6);
        assertTrue(position == -1);
    }
}