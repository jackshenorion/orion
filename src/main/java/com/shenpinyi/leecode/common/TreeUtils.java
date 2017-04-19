package com.shenpinyi.leecode.common;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by jack on 19/04/2017.
 */
public class TreeUtils {

    public static TreeNode createTree(Integer[] a) {
        if (a == null || a.length == 0 || a[0] == null) {return null;}
        return createTree(a, new int[]{0});
    }

    private static TreeNode createTree(Integer[] a, int[] from) {
        if (from[0] > a.length - 1) {return null;}
        if (a[from[0]] == null) {
            from[0] ++;
            return null;
        } else {
            TreeNode current = new TreeNode(a[from[0]]);
            from[0] ++;
            current.left = createTree(a, from);
            current.right = createTree(a, from);
            return current;
        }
    }

    public static String printTreeConstructor(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        printTreeConstructor(sb, root);
        return sb.toString();
    }

    private static void printTreeConstructor(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append("null,");
        } else {
            builder.append(node.val+",");
            printTreeConstructor(builder, node.left);
            printTreeConstructor(builder, node.right);
        }
    }

    public static String printTreeInOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        printTreeInOrder(sb, root);
        return sb.toString();
    }

    private static void printTreeInOrder(StringBuilder builder, TreeNode node) {
        if (node != null) {
            printTreeInOrder(builder, node.left);
            builder.append(node.val+",");
            printTreeInOrder(builder, node.right);
        }
    }
}
