package com.shenpinyi.lintcode.binarytree.question448;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.Stack;

public class Solution {

    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left == null) {
                return root;
            } else {
                return left;
            }
        }
    }

    public TreeNode inorderSuccessorB(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == p.val) {
                break;
            } else if (p.val < current.val) {
                stack.push(current);
                current = current.left;
            } else {
                stack.push(current);
                current = current.right;
            }
        }
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            result = current;
        } else {
            while (!stack.empty() && stack.peek().right == current) {
                current = stack.pop();
            }
            if (!stack.empty()) {
                result = stack.pop();
            }
        }
        return result;
    }
}
