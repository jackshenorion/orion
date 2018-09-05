package com.shenpinyi.lintcode.binarytree.question88;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree(new int[]{4, 3, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 6});
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
        if (root.val == A.val || root.val == B.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestorC(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }

        LinkedList<TreeNode> pathToA = new LinkedList<>();
        LinkedList<TreeNode> pathToB = new LinkedList<>();
        getPath(root, A, pathToA);
        getPath(root, B, pathToB);
        int i = 0;
        int maxDepth = Math.min(pathToA.size(), pathToB.size());
        while (i < maxDepth && pathToA.get(i) == pathToB.get(i)) {
            i++;
        }
        return i > 0 ? pathToA.get(i - 1) : null;
    }

    public boolean getPath(TreeNode current, TreeNode target, LinkedList<TreeNode> path) {
        if (current == null) {
            return false;
        } else if (current.val == target.val) {
            path.addLast(current);
            return true;
        } else {
            path.addLast(current);
            boolean inLeft = getPath(current.left, target, path);
            if (inLeft) {
                return true;
            }
            boolean inRight = getPath(current.right, target, path);
            if (inRight){
                return true;
            } else {
                path.removeLast();
                return false;
            }
        }
    }


    public TreeNode lowestCommonAncestorB(TreeNode root, TreeNode A, TreeNode B) {
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
            return lowestCommonAncestorB(root.left, A, B);
        } else if (rightA && rightB) {
            return lowestCommonAncestorB(root.right, A, B);
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
