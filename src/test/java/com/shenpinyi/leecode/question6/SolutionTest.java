package com.shenpinyi.leecode.question6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 29/03/2017.
 */
public class SolutionTest {

    @Test
    public void testConvert() throws Exception {
        System.out.println(new Solution().convert(null, 4));
        System.out.println(new Solution().convert("", 4));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 2));
        System.out.println(new Solution().convert("PAYPALISHIRING", 1));
        System.out.println(new Solution().convert("PAYPALISHIRING", 0));
    }
}