package com.shenpinyi.microsoft.question014;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 14/03/2017.
 */
public class TargetSumFinderTest {

    @Test
    public void testFind() throws Exception {
        int[] a = new int[]{1, 2, 4, 7, 11, 15};
        TargetSumFinder.find(a, 15);
    }
}