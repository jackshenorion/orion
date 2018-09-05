package com.shenpinyi.lintcode.binarytree.question93;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isBalanced() {
        TreeNode root = TreeUtils.createTree(new int[]{3,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7});
//        TreeNode root = TreeUtils.createTree(new int[]{1,2,3,4,Integer.MIN_VALUE,5,6,7,8,9,10,11,12});
        Solution solution = new Solution();
        assertTrue(solution.isBalanced(root));

    }
}