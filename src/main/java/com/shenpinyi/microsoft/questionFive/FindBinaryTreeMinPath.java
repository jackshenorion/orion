package com.shenpinyi.microsoft.questionFive;

import com.shenpinyi.utils.tree.BinaryTree;

public class FindBinaryTreeMinPath {

    public static void findMinPath(BinaryTree<Integer> tree, int pathLength) {
        findMinPath(tree.getRoot(), pathLength, new int[10], 0);
    }

    private static void findMinPath(BinaryTree.BinaryTreeNode<Integer> subRoot, int pathLength, int[] pathNodes, int pathCount) {
        if (subRoot.getValue() > pathLength) {
            return;
        } else if (subRoot.getValue() == pathLength && subRoot.getLeft() == null && subRoot.getRight() == null) {
            pathNodes[pathCount++] = subRoot.getValue();
            printPath(pathNodes, pathCount);
            return;
        } else {
            if (subRoot.getLeft() != null) {
                pathNodes[pathCount] = subRoot.getValue();
                findMinPath(subRoot.getLeft(), pathLength - subRoot.getValue(), pathNodes, pathCount + 1);
            }

            if (subRoot.getRight() != null) {
                pathNodes[pathCount] = subRoot.getValue();
                findMinPath(subRoot.getRight(), pathLength - subRoot.getValue(), pathNodes, pathCount + 1);
            }
        }
    }

    private static void printPath(int[] pathNodes, int pathCount) {
        System.out.print("\nFind a path:");
        for (int i = 0; i < pathCount; i ++) {
            System.out.print(pathNodes[i] + " ");
        }
    }
}
