package com.shenpinyi.leecode.question372;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 5/04/2017.
 */
public class SolutionTest {

    @Test
    public void testSuperPow() throws Exception {
        int i = 0;
        double exp = 1;
        while (i ++ < 1000) {
            exp *= 3;
            System.out.println(i + "  " + exp % 1337 + " ");
        }
    }
}