package com.shenpinyi.leecode.question372;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 5/04/2017.
 */
public class SolutionTest {

    @Test
    public void testSuperPow() throws Exception {
        System.out.println(2147483647 % 1337);
        System.out.println(2147483647 / 1337);
        System.out.println(1606195 * 1337 + 932);

        System.out.println(Math.pow(932, 2) % 1337);
        System.out.println(Math.pow(932 + 1606195*1337, 2) % 1337);
        System.out.println(Math.pow(2147483647, 2) % 1337);
        System.out.println((Math.pow(911, 10)) % 1337);
        System.out.println((Math.pow(436, 10)) % 1337);

        for (int i = 100; i < 200; i++) {
            System.out.println(Math.pow(932 + i*1337, 2) % 1337);
        }

        System.out.println(new Solution().superPow(932, new int[]{2, 0, 0}));
    }
}