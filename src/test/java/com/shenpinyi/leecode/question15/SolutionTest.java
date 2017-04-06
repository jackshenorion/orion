package com.shenpinyi.leecode.question15;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 5/04/2017.
 */
public class SolutionTest {

    @Test
    public void testThreeSum() throws Exception {
        print(new Solution().threeSum(new int[] {-1, 0, 1, 2, -1, -4, -2, 0, 0, 0}));
    }

    private void print(List<List<Integer>> threeSums) {
        threeSums.forEach(threes -> {
            threes.forEach(num -> System.out.print(num + " "));
            System.out.println();
        }
        );
    }
}