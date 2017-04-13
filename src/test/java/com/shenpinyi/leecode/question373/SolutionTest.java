package com.shenpinyi.leecode.question373;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 13/04/2017.
 */
public class SolutionTest {

    @Test
    public void testKSmallestPairs() throws Exception {
        List<int[]> output = new Solution().kSmallestPairs(new int[]{1,7, 13, 19, 25, 31}, new int[]{1, 3, 5, 7, 9, 10, 12}, 20);
        List<int[]> output1 = new Solution().kSmallestPairs(new int[]{3,5,7,9}, new int[]{}, 1);
        output.forEach(e -> System.out.println(e[0] + "," + e[1]));
    }
}