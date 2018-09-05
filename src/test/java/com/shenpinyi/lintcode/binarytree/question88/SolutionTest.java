package com.shenpinyi.lintcode.binarytree.question88;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lowestCommonAncestor() {

        TreeNode root = TreeUtils.createTree(new int[]{4, 3, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 6});
        assertEquals(4, new Solution().lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5)).val);
        assertEquals(7, new Solution().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)).val);
        assertEquals(7, new Solution().lowestCommonAncestor(root, new TreeNode(6), new TreeNode(7)).val);


    }
}