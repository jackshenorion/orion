package com.shenpinyi.lintcode.binarytree.question68;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {

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
                    prev = current;
                } else if (current.right != null) {
                    stack.push(current.right);
                    prev = current;
                } else {
                    stack.pop();
                    result.add(current.val);
                    prev = current;
                }
            } else if (current.left == prev) { // back from left
                if (current.right == null) {
                    stack.pop();
                    result.add(current.val);
                    prev = current;
                } else {
                    stack.push(current.right);
                    prev = current;
                }
            } else if (current.right == prev) { // back from right
                stack.pop();
                result.add(current.val);
                prev = current;
            }
        }
        return result;
    }
}
