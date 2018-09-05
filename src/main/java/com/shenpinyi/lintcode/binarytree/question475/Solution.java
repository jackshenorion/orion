package com.shenpinyi.lintcode.binarytree.question475;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {

    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int max = Math.max(left, right);
        int current = root.val;
        if (max > 0) {
             return current + max;
        } else {
            return current;
        }
    }

}
