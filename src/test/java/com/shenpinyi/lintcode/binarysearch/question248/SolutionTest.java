package com.shenpinyi.lintcode.binarysearch.question248;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void countOfSmallerNumber() {
        List<Integer> results = new Solution().countOfSmallerNumber(new int[]{1, 2, 7, 8, 5}, new int[]{1, 8, 5});
        assertArrayEquals(new Integer[] {0,4,2}, results.toArray(new Integer[3]));
        assertArrayEquals(new Integer[] {0,0,0}, new Solution().countOfSmallerNumber(new int[]{}, new int[]{1, 8, 5}).toArray(new Integer[3]));
    }
}