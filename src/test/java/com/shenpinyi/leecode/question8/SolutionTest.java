package com.shenpinyi.leecode.question8;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 30/03/2017.
 */
public class SolutionTest {

    @Test
    public void testMyAtoi() throws Exception {
        Assert.assertEquals(new Solution().myAtoi(null), 0);
        Assert.assertEquals(new Solution().myAtoi("      -11919730356x"), Integer.MIN_VALUE);
        Assert.assertEquals(new Solution().myAtoi("-2147483648"), -2147483648);
        Assert.assertEquals(new Solution().myAtoi(" "), 0);
        Assert.assertEquals(new Solution().myAtoi("  a"), 0);
        Assert.assertEquals(new Solution().myAtoi("1"), 1);
        Assert.assertEquals(new Solution().myAtoi("  12345a"), 12345);
        Assert.assertEquals(new Solution().myAtoi("1234567890"), 1234567890);
        Assert.assertEquals(new Solution().myAtoi("-1234567890"), -1234567890);
        Assert.assertEquals(new Solution().myAtoi("9876543210"), Integer.MAX_VALUE);
        Assert.assertEquals(new Solution().myAtoi("  000001234567890"), 1234567890);
        Assert.assertEquals(new Solution().myAtoi("  +000001234567890"), 1234567890);
        Assert.assertEquals(new Solution().myAtoi("  -000001234567890"), -1234567890);
        Assert.assertEquals(new Solution().myAtoi("  00+0001234567890"), 0);
        Assert.assertEquals(new Solution().myAtoi("1234567890123456789012345678901234567890"), Integer.MAX_VALUE);

    }
}