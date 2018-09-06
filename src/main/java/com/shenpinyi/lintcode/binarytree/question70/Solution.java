package com.shenpinyi.lintcode.binarytree.question70;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.*;

public class Solution {

    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int levelSize = queue.size();
            List<Integer> levelVals = new ArrayList<>();
            results.add(levelVals);
            while (levelSize > 0) {
                TreeNode current = queue.poll();
                levelVals.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                levelSize--;
            }
        }
        Collections.reverse(results);
        return results;
    }
}
