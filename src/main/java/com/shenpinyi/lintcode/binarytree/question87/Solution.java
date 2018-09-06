package com.shenpinyi.lintcode.binarytree.question87;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {

    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        TreeNode last = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == value) {
                break;
            } else if (value < current.val) {
                last = current;
                current = current.left;
            } else {
                last = current;
                current = current.right;
            }
        }
        if (current == null) {
            return root;
        }
        if (current.right == null && current.left == null) {
            if (last == null) {
                return null;
            } else {
                if (last.left == current) {
                    last.left = null;
                } else {
                    last.right = null;
                }
            }
        } else if (current.right == null) {
            if (last == null) {
                return current.left;
            } else {
                if (last.left == current) {
                    last.left = current.left;
                } else {
                    last.right = current.left;
                }
            }
        } else if (current.left == null) {
            if (last == null) {
                return current.right;
            } else {
                if (last.left == current) {
                    last.left = current.right;
                } else {
                    last.right = current.right;
                }
            }
        } else {
            TreeNode next = current.right;
            while (next.left != null) {
                next = next.left;
            }

            removeNode(root, next.val);
            current.val = next.val;
        }
        return root;
    }
}
