package com.shenpinyi.leecode.question145;

/**
 * Created by jack on 5/04/2017.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.add(root);
        }

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            output.addFirst(current.val);
            if (current.left != null) {
                stack.add(current.left);
            }

            if (current.right != null) {
                stack.add(current.right);
            }
        }
        return output;
    }

    public List<Integer> postorderTraversalWrong2(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return output;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();
            output.addFirst(current.val);
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        return  output;
    }

    public List<Integer> postorderTraversalWrong(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode next = root;
        while (next != null) {
            stack.add(next);
            next = next.right;
        }

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            output.add(current.val);
            next = current.left;
            while (next != null) {
                stack.add(next);
                next = next.right;
            }
        }

        return output;
    }

}