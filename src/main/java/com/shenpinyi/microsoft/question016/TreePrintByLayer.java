package com.shenpinyi.microsoft.question016;

import com.shenpinyi.utils.tree.BinaryTree;
import com.shenpinyi.utils.tree.Entry;

import java.util.LinkedList;

/**
 * Created by jack on 15/03/2017.
 */
public class TreePrintByLayer {

    public static <K, V> void print(BinaryTree<K, V> tree) {
        StringBuilder builder = new StringBuilder();
        LinkedList<Entry<K, V>> queue = new LinkedList<>();
        if (tree == null || tree.root == null) {
            return;
        }
        queue.add(tree.root);
        while (queue.size() != 0) {
            Entry<K, V> current = queue.pollFirst();
            builder.append(current.key + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println(builder.toString());
    }

}
