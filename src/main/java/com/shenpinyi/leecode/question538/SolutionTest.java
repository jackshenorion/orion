package com.shenpinyi.leecode.question538;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 27/03/2017.
 */
public class SolutionTest {

    @Test
    public void testConvertBST() throws Exception {
        TreeNode tree = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        tree.left = node2;
        tree.right = node13;
        node13.left = node8;
        node13.right = node15;
        node8.left = node7;
        printTree(new Solution().convertBST(tree));

    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}