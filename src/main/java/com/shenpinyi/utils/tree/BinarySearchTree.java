package com.shenpinyi.utils.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    SimpleEntry<T> root;

    public BinarySearchTree() {
    }

    public SimpleEntry<T> getRoot() {
        return root;
    }

    public BinarySearchTree add(T value) {
        if (root == null) {
            root = new SimpleEntry<>().setValue(value).setLeft(null).setRight(null);
        } else {
            add(root, value);
        }
        return this;
    }

    private BinarySearchTree add(SimpleEntry<T> subRoot, T value) {
        int compareResult = value.compareTo(subRoot.getValue());

        if (compareResult == 0) {
            return this;
        }

        if (compareResult < 0 && subRoot.left != null){
            add(subRoot.left, value);
        } else if (compareResult > 0 && subRoot.right != null) {
            add(subRoot.right, value);
        } else if ( compareResult < 0 && subRoot.left == null) {
            subRoot.left = new SimpleEntry<>().setValue(value).setLeft(null).setRight(null);
        } else {
            subRoot.right = new SimpleEntry<>().setValue(value).setLeft(null).setRight(null);
        }

        return this;
    }

}
