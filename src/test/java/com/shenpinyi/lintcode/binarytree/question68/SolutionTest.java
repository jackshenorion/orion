package com.shenpinyi.lintcode.binarytree.question68;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void postorderTraversal() {
        TreeNode root = TreeUtils.createTree(new int[]{1, Integer.MIN_VALUE, 2, 3});
        Solution solution = new Solution();
        List<Integer> path = solution.postorderTraversal(root);
        assertArrayEquals(new Integer[]{3, 2, 1}, path.toArray());
    }
}