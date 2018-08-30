package com.shenpinyi.lintcode.binarysearch.question39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void recoverRotatedSortedArray() {

        assertEquals(2, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(4, 5, 1, 2, 3))));
        assertEquals(1, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4))));
        assertEquals(3, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))));
        assertEquals(0, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        assertEquals(4, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 1))));
        assertEquals(9, new Solution().getSmallestIndex(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))));

        ArrayList<Integer> nums;

        nums = new ArrayList<>(Arrays.asList(4, 5, 1, 2, 3));
        Integer[] target = new Integer[]{1, 2, 3, 4, 5};
        new Solution().recoverRotatedSortedArray(nums);
        assertArrayEquals(target, nums.toArray(new Integer[5]));

        nums = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4));
        new Solution().recoverRotatedSortedArray(nums);
        assertArrayEquals(target, nums.toArray(new Integer[5]));

        nums = new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2));
        new Solution().recoverRotatedSortedArray(nums);
        assertArrayEquals(target, nums.toArray(new Integer[5]));

        nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        new Solution().recoverRotatedSortedArray(nums);
        assertArrayEquals(target, nums.toArray(new Integer[5]));

        nums = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 1));
        new Solution().recoverRotatedSortedArray(nums);
        assertArrayEquals(target, nums.toArray(new Integer[5]));
    }
}