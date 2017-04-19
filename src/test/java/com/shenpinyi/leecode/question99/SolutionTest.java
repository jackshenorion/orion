package com.shenpinyi.leecode.question99;

import com.shenpinyi.leecode.common.TreeNode;
import com.shenpinyi.leecode.common.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 18/04/2017.
 */
public class SolutionTest {

    @Test
    public void testRecoverTree() throws Exception {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        TreeNode root = node6;
        node6.left = node2;
        node6.right = node3;
        node2.left = node1;
        node2.right = node5;
        node5.left = node8;
        node8.right = node4;
        node3.left = node7;
        node3.right = node9;

        System.out.println(TreeUtils.printTreeConstructor(root));
        System.out.println(TreeUtils.printTreeInOrder(root));
        new Solution().recoverTree(root);
        System.out.println(TreeUtils.printTreeConstructor(root));
        System.out.println(TreeUtils.printTreeInOrder(root));
    }

    @Test
    public void testRecoverTree1() throws Exception {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);

        TreeNode root = node0;
        node0.left = node1;
        new Solution().recoverTree(root);
        new Solution().recoverTree(root);
    }

    @Test
    public void testRecoverTree2() throws Exception {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode root = node2;
        node2.right = node3;
        node3.left = node1;

        new Solution().recoverTree(root);
        new Solution().recoverTree(root);
    }

    @Test
    public void testRecoverTree3() throws Exception {
        TreeNode root = TreeUtils.createTree(new Integer[]{68,41,-85,-73,-98,-124,null,null,-49});
        System.out.println(TreeUtils.printTreeInOrder(root));
        System.out.println(TreeUtils.printTreeConstructor(root));
        new Solution().recoverTree(root);
        System.out.println(TreeUtils.printTreeInOrder(root));
        System.out.println(TreeUtils.printTreeConstructor(root));

    }
}