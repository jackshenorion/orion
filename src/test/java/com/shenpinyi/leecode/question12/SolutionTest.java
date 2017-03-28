package com.shenpinyi.leecode.question12;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 28/03/2017.
 */
public class SolutionTest {

    @Test
    public void testIntToRoman() throws Exception {
        Assert.assertEquals(new Solution().intToRoman(1), "I");
        Assert.assertEquals(new Solution().intToRoman(10), "X");
        Assert.assertEquals(new Solution().intToRoman(40), "XL");
        Assert.assertEquals(new Solution().intToRoman(50), "L");
        Assert.assertEquals(new Solution().intToRoman(90), "XC");
        Assert.assertEquals(new Solution().intToRoman(100), "C");
        Assert.assertEquals(new Solution().intToRoman(400), "CD");
        Assert.assertEquals(new Solution().intToRoman(500), "D");
        Assert.assertEquals(new Solution().intToRoman(900), "CM");
        Assert.assertEquals(new Solution().intToRoman(1000), "M");
        Assert.assertEquals(new Solution().intToRoman(3999), "MMMCMXCIX");
        System.out.print(new Solution().intToRoman(3250));
    }
}