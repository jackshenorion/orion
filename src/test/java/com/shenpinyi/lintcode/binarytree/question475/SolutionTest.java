package com.shenpinyi.lintcode.binarytree.question475;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxPathSum2() {
        TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3});
        assertEquals(4, new Solution().maxPathSum2(root));
        assertEquals(-1, new Solution().maxPathSum2(TreeUtils.createTree(new int[]{-1})));
        assertEquals(-1, new Solution().maxPathSum2(TreeUtils.createTree(new int[]{-1, -2, -3})));
    }
}