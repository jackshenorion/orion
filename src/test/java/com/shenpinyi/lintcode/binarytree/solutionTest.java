package com.shenpinyi.lintcode.binarytree;

import com.shenpinyi.lintcode.binarytree.question67.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class solutionTest {

    @Test
    public void inorderTraversal() {
        TreeNode root = TreeUtils.createTree(new int[]{1, Integer.MIN_VALUE, 2, 3});
        assertArrayEquals(new Integer[]{1,3,2}, new Solution().inorderTraversal(root).toArray());


    }
}