package com.shenpinyi.microsoft.question011;

import com.shenpinyi.utils.tree.BinaryTree;
import com.shenpinyi.utils.tree.BinaryTreePrinter;
import com.shenpinyi.utils.tree.Entry;

public class LongestPathFinder {
    BinaryTree<String, EntryValue> binaryTree;
    private Entry<String, EntryValue> maxLengthNode;
    private int maxLength = 0;

    public LongestPathFinder(BinaryTree<String, EntryValue> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public void findMaxLengthPath() {
        calcHeight(binaryTree.root);
        maxLengthNode.key = "(" + maxLengthNode.key + ")";
        markMaxLenghtPath(maxLengthNode.left);
        markMaxLenghtPath(maxLengthNode.right);
        System.out.println("The max length is: " + maxLength);
        BinaryTreePrinter.printNode(binaryTree.root);
    }

    private int calcHeight(Entry<String, EntryValue> tree) {
        if (tree == null) {
            return 0;
        }
        int leftHeight = calcHeight(tree.left);
        int rightHeight = calcHeight(tree.right);
        tree.value.height = Math.max(leftHeight, rightHeight) + 1;
        tree.value.isLeftLonger = leftHeight >= rightHeight;
        if ((leftHeight + rightHeight + 1) > maxLength) {
            maxLength = leftHeight + rightHeight + 1;
            maxLengthNode = tree;
        }

        return tree.value.height;
    }

    private void markMaxLenghtPath(Entry<String, EntryValue> tree) {
        if (tree == null) {
            return;
        }
        tree.key = "(" + tree.key + ")";
        markMaxLenghtPath(tree.value.isLeftLonger ? tree.left : tree.right);
    }
}
