package com.shenpinyi.lintcode.binarytree.question69;

import com.shenpinyi.lintcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, 0, results);
        return results;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> results) {
        if (node == null) {
            return;
        }
        if (level >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);
        helper(node.left, level + 1, results);
        helper(node.right, level + 1, results);
    }

}
