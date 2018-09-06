package com.shenpinyi.lintcode.binarytree.question87;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeNode() {

        TreeNode root = TreeUtils.createTree(new int[]{5, 3, 6, 2, 4});
        new Solution().removeNode(root, 3);
    }
}