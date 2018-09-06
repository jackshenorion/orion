package com.shenpinyi.lintcode.binarytree.question11;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.*;

public class Solution {

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> results = new ArrayList<>();
        // step 1: find where to start
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null) {
            if (current.val == k1) {
                stack.push(current);
                break;
            } else if (current.val < k1) {
                stack.push(current);
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        // step 2: traverse
        while (!stack.empty()) {
            current = stack.peek();
            if (current.val >= k1 && current.val <= k2) {
                results.add(current.val);
            } else if (current.val > k2) {
                break;
            }
            if (current.right != null) {
                current = current.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            } else {
                current = stack.pop();
                while (!stack.empty() && stack.peek().right == current) {
                    current = stack.pop();
                }
            }
        }
        return results;
    }
}
