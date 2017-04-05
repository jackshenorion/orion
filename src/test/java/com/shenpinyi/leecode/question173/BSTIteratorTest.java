package com.shenpinyi.leecode.question173;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 5/04/2017.
 */
public class BSTIteratorTest {

    @Test
    public void testBSTIterator() throws Exception {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node5.left = node2;
        node5.right = node8;
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node8.left = node6;
        node8.right = node9;
        node6.right = node7;

        BSTIterator iter = new BSTIterator(node5);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}