package com.shenpinyi.utils.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    BinaryTreeNode<T> root;

    public BinarySearchTree() {
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public BinarySearchTree add(T value) {
        if (root == null) {
            root = new BinaryTreeNode<>().setValue(value).setLeft(null).setRight(null);
        } else {
            add(root, value);
        }
        return this;
    }

    private BinarySearchTree add(BinaryTreeNode<T> subRoot, T value) {
        int compareResult = value.compareTo(subRoot.getValue());

        if (compareResult == 0) {
            return this;
        }

        if (compareResult < 0 && subRoot.left != null){
            add(subRoot.left, value);
        } else if (compareResult > 0 && subRoot.right != null) {
            add(subRoot.right, value);
        } else if ( compareResult < 0 && subRoot.left == null) {
            subRoot.left = new BinaryTreeNode<>().setValue(value).setLeft(null).setRight(null);
        } else {
            subRoot.right = new BinaryTreeNode<>().setValue(value).setLeft(null).setRight(null);
        }

        return this;
    }

    public static class BinaryTreeNode <T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public T getValue() {
            return value;
        }

        public BinaryTreeNode setValue(T value) {
            this.value = value;
            return this;
        }

        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        public BinaryTreeNode setLeft(BinaryTreeNode<T> left) {
            this.left = left;
            return this;
        }

        public BinaryTreeNode<T> getRight() {
            return right;
        }

        public BinaryTreeNode setRight(BinaryTreeNode<T> right) {
            this.right = right;
            return this;
        }
    }
}
