package com.shenpinyi.lintcode.binarytree;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    //{1,2,3,4,#,5,6,7,8,9,10,11,12}

    public static TreeNode createTree(int[] tree) {
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> nodes = new LinkedList<>();
        int currentIndex = 0;
        nodes.offer(root);
        while(nodes.size() > 0) {
            TreeNode node = nodes.poll();
            int leftSonIndex = currentIndex + 1;
            int rightSonIndex = currentIndex + 2;
            if (leftSonIndex < tree.length) {
                int leftValue = tree[leftSonIndex];
                if (leftValue > Integer.MIN_VALUE) {
                    node.left = new TreeNode(leftValue);
                    nodes.offer(node.left);
                }
            }
            if (rightSonIndex < tree.length) {
                int rightValue = tree[rightSonIndex];
                if (rightValue > Integer.MIN_VALUE) {
                    node.right = new TreeNode(rightValue);
                    nodes.offer(node.right);
                }
            }
            currentIndex += 2;
        }
        return root;
    }
}
