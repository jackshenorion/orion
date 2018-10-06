package com.shenpinyi.microsoft.question015;

import com.shenpinyi.utils.tree.BinaryTree;
import com.shenpinyi.utils.tree.Entry;

import java.util.LinkedList;

/**
 * Created by jack on 15/03/2017.
 */
public class BinaryTreeFlipOver {

    public static <K, V> BinaryTree<K, V> flipOver(BinaryTree<K, V> tree) {
        //flipOver(tree.root);
        flipOver2(tree.root);
        return tree;
    }

    private static <K, V> void flipOver(Entry<K, V> tree) {
        if (tree == null) {
            return;
        }

        Entry temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        flipOver(tree.left);
        flipOver(tree.right);
    }

    private static <K, V> void flipOver2(Entry<K, V> tree) {
        LinkedList<Entry<K, V>> inprogress = new LinkedList<>();
        inprogress.push(tree);
        while(inprogress.size() != 0) {
            Entry<K, V> current = inprogress.pop();
            Entry temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                inprogress.push(current.left);
            }
            if (current.right != null) {
                inprogress.push(current.right);
            }
        }
    }

}
