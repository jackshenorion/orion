package com.shenpinyi.lintcode.binarytree.question93;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        if (l == -1 || r == -1) {
            return -1;
        } else {
            int diff = l - r >= 0 ? l - r : r - l;
            int max = l > r ? l : r;
            return diff > 1 ? -1 : max + 1;
        }
    }
}
