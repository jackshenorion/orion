package com.shenpinyi.lintcode.binarytree.question93;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree(new int[]{3,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7});
//        TreeNode root = TreeUtils.createTree(new int[]{1,2,3,4,Integer.MIN_VALUE,5,6,7,8,9,10,11,12});
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1;
        }
        return false;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
    }
}
