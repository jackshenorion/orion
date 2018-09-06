package com.shenpinyi.lintcode.binarytree.question11;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchRange() {
        TreeNode root = TreeUtils.createTree(new int[]{20, 8, 22, 4, 12});
        assertArrayEquals(new Integer[]{12, 20, 22}, new Solution().searchRange(root, 10, 22).toArray());
        assertArrayEquals(new Integer[]{20, 35}, new Solution().searchRange(TreeUtils.createTree(new int[]{20,1,40,Integer.MIN_VALUE,Integer.MIN_VALUE,35}), 17, 37).toArray());
    }
}