package com.shenpinyi.lintcode.binarytree.question88;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree(new int[]{4,3,7,Integer.MIN_VALUE, Integer.MIN_VALUE, 5,6});
        Solution solution = new Solution();
        System.out.println(solution);
    }

    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }
        boolean leftA = contains(root.left, A);
        boolean leftB = contains(root.left, B);
        boolean rightA = contains(root.right, A);
        boolean rightB = contains(root.right, B);

        if (leftA && leftB) {
            return lowestCommonAncestor(root.left, A, B);
        } else if(rightA && rightB) {
            return lowestCommonAncestor(root.right, A, B);
        } else {
            return root;
        }
    }

    private boolean contains(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return contains(root.left, node) || contains(root.right, node);
    }
}
