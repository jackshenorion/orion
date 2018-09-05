package com.shenpinyi.lintcode.binarytree.question448;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void inorderSuccessor() {
        assertEquals(2, new Solution().inorderSuccessor(TreeUtils.createTree(new int[]{2, 1}), new TreeNode(1)).val);
        assertEquals(3, new Solution().inorderSuccessor(TreeUtils.createTree(new int[]{2, 1, 3}), new TreeNode(2)).val);
    }
}