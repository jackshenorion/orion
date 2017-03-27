package com.shenpinyi.leecode.question538;


public class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode node, int addon) {
        if (node.right == null) {
            node.val += addon;
        } else {
            node.val += convert(node.right, addon);
        }

        if (node.left == null) {
            return node.val;
        } else {
            return convert(node.left, node.val);
        }
    }
}