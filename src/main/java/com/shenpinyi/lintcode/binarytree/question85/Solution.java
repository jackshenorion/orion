package com.shenpinyi.lintcode.binarytree.question85;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {

    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode current = root;
        while (true) {
            if (current.val == node.val) {
                break;
            } else if (current.val > node.val) {
                if (current.left == null) {
                    current.left = node;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                } else {
                    current = current.right;
                }
            }
        }
        return root;
    }
}
