package com.shenpinyi.leecode.question99;

/**
 * Created by jack on 18/04/2017.
 */

import com.shenpinyi.leecode.common.TreeNode;

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

    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode highError = null;
        TreeNode lowError = null;
        TreeNode last = null;
        while (current != null) {
            TreeNode output = null;
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                    continue;
                } else {
                    predecessor.right = null;
                    output = current;
                    current = current.right;
                }
            } else {
                output = current;
                current = current.right;
            }

            if (highError == null) {
                if (last != null && output.val < last.val) {
                    highError = last;
                }
            } else {
                if (lowError == null && output.val > highError.val) {
                    lowError = last;
                }
            }
            last = output;
        }
        if (lowError == null) {
            lowError = last;
        }
        if (highError != null) {
            int temp = highError.val;
            highError.val = lowError.val;
            lowError.val = temp;
        }
    }
}