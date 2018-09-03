package com.shenpinyi.lintcode.binarytree.question67;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversalB(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        boolean isForward = true;
        while (true){
            if (isForward) {
                if (current == null) {
                    if (stack.empty()) {
                        break;
                    } else {
                        current = stack.pop();
                        isForward = false;
                    }
                } else {
                    stack.push(current);
                    current = current.left;
                }
            } else {
                result.add(current.val);
                current = current.right;
                isForward = true;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode current = stack.peek();
            if (prev == null || prev.right == current || prev.left == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else {
                    result.add(current.val);
                    if (current.right != null) {
                        stack.push(current.right);
                    } else {
                        stack.pop();
                    }
                }
            } else if (current.left == prev) { // back from left
                result.add(current.val);
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                }
            } else if (current.right == prev) { // back from right
                stack.pop();
            }
            prev = current;
        }
        return result;
    }
}
