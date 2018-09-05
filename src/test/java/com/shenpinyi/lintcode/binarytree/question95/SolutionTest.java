package com.shenpinyi.lintcode.binarytree.question95;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isValidBST() {
        assertTrue(new Solution().isValidBST(TreeUtils.createTree(new int[]{2, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 5})));
        assertFalse(new Solution().isValidBST(TreeUtils.createTree(new int[]{2, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, -1, 5})));
    }
}