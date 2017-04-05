package com.shenpinyi.leecode.question173;

/**
 * Created by jack on 5/04/2017.
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode next = root;
        while (next != null) {
            stack.add(next);
            next = next.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        TreeNode current = stack.removeLast();
        TreeNode nextRoot = current.right;

        while (nextRoot != null) {
            stack.add(nextRoot);
            nextRoot = nextRoot.left;
        }

        return current.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */