package com.shenpinyi.lintcode.binarytree.question94;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxPathSum(TreeUtils.createTree(new int[] {1, 2, 3})));
        System.out.println(new Solution().maxPathSum(TreeUtils.createTree(new int[] {-1})));
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        long leftLag = maxLag(root.left);
        long rightLag = maxLag(root.right);
        int current = root.val;
        long thisMax = Math.max(leftLag + current + rightLag, Math.max(leftLag + current, Math.max(rightLag + current, current)));
        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        return (int) Math.max(thisMax, Math.max(leftMax, rightMax));
    }

    public long maxLag(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        long left = maxLag(node.left);
        long right = maxLag(node.right);
        int current = node.val;
        return Math.max(current, Math.max(current + left, current + right));
    }

    public int maxPathSumB(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxPathWithNode = maxPathWithNode(root);
        maxSum = Math.max(maxSum, maxPathWithNode);
        if (root.left != null) {
            maxSum = Math.max(maxSum, maxPathSum(root.left));
        }
        if (root.right != null) {
            maxSum = Math.max(maxSum, maxPathSum(root.right));
        }
        return maxSum;
    }

    private int maxPathWithNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxLeg(root.left);
        int maxRight = maxLeg(root.right);
        return maxLeft + maxRight + root.val;
    }

    private int maxLeg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxLeg(root.left);
        int maxRight = maxLeg(root.right);
        return Math.max(Math.max(maxLeft, maxRight) + root.val, 0);
    }
}
