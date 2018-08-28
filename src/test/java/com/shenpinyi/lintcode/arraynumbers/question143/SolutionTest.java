package com.shenpinyi.lintcode.arraynumbers.question143;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortColors2() {
        int[] nums = {3, 2, 2, 1, 4};
        new Solution().sortColors2(nums, 4);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4}, nums);
    }
    @Test
    public void sortColors2B() {
        int[] nums = {3,2,3,3,4,3,3,2,4,4,1,2,1,1,1,3,4,3,4,2};
        new Solution().sortColors2(nums, 4);
        assertArrayEquals(new int[]{1,1,1,1,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4}, nums);
    }
    @Test
    public void sortColors2C() {
        int[] nums = {4,2,1,4,4,4,1,4,2,1,2,4,4,5,3,2,5,5,5,3,2,1,4,2,3,2,4,3,2,5};
        new Solution().sortColors2(nums, 5);
        assertArrayEquals(new int[]{1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,5}, nums);
    }
}