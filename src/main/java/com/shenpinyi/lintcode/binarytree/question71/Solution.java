package com.shenpinyi.lintcode.binarytree.question71;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.*;

public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelVals = new ArrayList<>();
            result.add(levelVals);
            while (size > 0 ) {
                TreeNode current = queue.poll();
                levelVals.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                size--;
            }
        }

        int level = result.size();
        for (int i = 1; i < level; i = i + 2) {
            Collections.reverse(result.get(i));
        }
        return result;
    }
}
