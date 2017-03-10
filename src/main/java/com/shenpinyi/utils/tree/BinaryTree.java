package com.shenpinyi.utils.tree;

import java.util.List;

/**
 *
 * @param <K> the type of keys in this tree
 * @param <V> the type of value in this tree
 */
public class BinaryTree <K, V> {
    public Entry<K, V> root;

    /**
     * use list of nodes in pre-order to build a binary tree
     *
     * @param nodes
     */
    public BinaryTree(List<Entry<K, V>> nodes) {
        if (nodes.size() == 0 || nodes.get(0) == null) {
            return;
        }
        root = nodes.get(0);
        buildTree(root, 1, nodes);
    }

    private int buildTree(Entry<K, V> tree, int next, List<Entry<K, V>> nodes) {
        if (next == nodes.size()) {
            return next;
        }

        Entry left = nodes.get(next++);
        if (left != null) {
            tree.left = left;
            left.parent = tree;
            next = buildTree(left, next, nodes);
        }

        if (next == nodes.size()) {
            return next;
        }

        Entry right = nodes.get(next++);
        if (right != null) {
            tree.right = right;
            right.parent = tree;
            next = buildTree(right, next, nodes);
        }

        return next;
    }

}
