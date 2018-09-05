package com.shenpinyi.lintcode.binarytree.question95;

import com.shenpinyi.lintcode.binarytree.TreeNode;

public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getTreeInfo(root).isValid;
    }

    private Result getTreeInfo(TreeNode node) {
        if (node == null) {
            return null;
        }
        Result leftResult = getTreeInfo(node.left);
        Result rightResult = getTreeInfo(node.right);
        if (leftResult == null && rightResult == null) {
            return new Result(true, node.val, node.val);
        } else if (leftResult != null && rightResult != null) {
            if (leftResult.isValid && rightResult.isValid) {
                boolean isValid = leftResult.maxValue < node.val && node.val < rightResult.minValue;
                return new Result(isValid, leftResult.minValue, rightResult.maxValue);
            } else {
                return new Result(false, leftResult.minValue, rightResult.maxValue);
            }
        } else if (leftResult != null) {
            return new Result(leftResult.isValid && leftResult.maxValue < node.val, leftResult.minValue, node.val);
        } else {
            return new Result(rightResult.isValid && node.val < rightResult.minValue, node.val, rightResult.maxValue);
        }
    }

    static class Result {
        boolean isValid;
        int minValue;
        int maxValue;

        public Result(boolean isValid, int minValue, int maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

}
