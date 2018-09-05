package com.shenpinyi.lintcode.binarytree.question86;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */


public class BSTIteratorB {
    /*
     * @param root: The root of binary tree.
     */
    Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorB(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !this.stack.empty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode result = null;
        if (stack.empty()) {
            return null;
        }
        result = stack.pop();
        TreeNode current = result.right;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        return result;
    }
}
