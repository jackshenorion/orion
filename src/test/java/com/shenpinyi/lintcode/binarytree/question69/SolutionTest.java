package com.shenpinyi.lintcode.binarytree.question69;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void levelOrder() {

        TreeNode root = TreeUtils.createTree(new int[]{3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7});
        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.print(lists);
    }
}