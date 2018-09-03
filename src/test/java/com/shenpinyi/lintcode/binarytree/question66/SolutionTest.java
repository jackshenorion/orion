package com.shenpinyi.lintcode.binarytree.question66;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void preorderTraversal() {
        TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3, 4, 5, Integer.MIN_VALUE, Integer.MIN_VALUE});
        Solution solution = new Solution();
        List<Integer> path = solution.preorderTraversal(root);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 3}, path.toArray());
    }

}