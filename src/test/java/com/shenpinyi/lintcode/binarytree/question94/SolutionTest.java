package com.shenpinyi.lintcode.binarytree.question94;

import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxPathSum() {
        assertEquals(6, new Solution().maxPathSum(TreeUtils.createTree(new int[] {1, 2, 3})));
        assertEquals(-1, new Solution().maxPathSum(TreeUtils.createTree(new int[] {-1})));
    }
}