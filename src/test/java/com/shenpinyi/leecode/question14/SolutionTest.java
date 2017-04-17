package com.shenpinyi.leecode.question14;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 17/04/2017.
 */
public class SolutionTest {

    @Test
    public void testLongestCommonPrefix() throws Exception {
        System.out.println(new Solution().longestCommonPrefix(new String[]{}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{""}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123456789"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123456789", "123400000", "1230"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123456789", "123400000", "123"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123456789", "0123400000", "123"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123456789", "123456789", "123456789"}));
    }
}