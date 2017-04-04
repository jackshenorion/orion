package com.shenpinyi.leecode.question78;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 3/04/2017.
 */
public class SolutionTest {

    @Test
    public void testSubsets() throws Exception {
        print(new Solution().subsets(new int[]{1,2,3,4}));
    }

    private void print(List<List<Integer>> subsets) {
        subsets.forEach(l -> {
            l.forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }
}