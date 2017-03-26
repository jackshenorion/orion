package com.shenpinyi.leecode.question383;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 26/03/2017.
 */
public class SolutionTest {

    @Test
    public void testCanConstruct() throws Exception {
        Assert.assertFalse(new Solution().canConstruct("a", "b"));
        Assert.assertFalse(new Solution().canConstruct("aa", "ab"));
        Assert.assertTrue(new Solution().canConstruct("aa", "aab"));
        Assert.assertTrue(new Solution().canConstruct("", "aab"));
        Assert.assertTrue(new Solution().canConstruct("aa", "aba"));
        Assert.assertFalse(new Solution().canConstruct("aa", "abc"));
    }
}