package com.shenpinyi.lintcode.binarytree.question595;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLen = 0;
        helper(root, 1);
        return maxLen;
    }

    private void helper(TreeNode root, int num) {
        maxLen = Math.max(maxLen, num);
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                helper(root.left, num + 1);
            } else {
                helper(root.left, 1);
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                helper(root.right, num + 1);
            } else {
                helper(root.right, 1);
            }
        }
    }
}
