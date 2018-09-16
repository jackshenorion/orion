package com.shenpinyi.lintcode.linkedlist.question378;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.linkedlist.DoublyListNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        return bstToDoublyListHelper(root).head;
    }

    public ResultPair bstToDoublyListHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        ResultPair left = bstToDoublyListHelper(root.left);
        ResultPair right = bstToDoublyListHelper(root.right);
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode tail = dummy;
        DoublyListNode midNode = new DoublyListNode(root.val);
        if (left != null) {
            tail.next = left.head;
            tail = left.tail;
        }
        tail.next = midNode;
        midNode.prev = tail;
        tail = midNode;
        if (right != null) {
            tail.next = right.head;
            right.head.prev = tail;
            tail = right.tail;
        }
        tail.next = null;
        return new ResultPair(dummy.next, tail);
    }

}

class ResultPair {
    DoublyListNode head = null;
    DoublyListNode tail = null;
    ResultPair(DoublyListNode head, DoublyListNode tail) {
        this.head = head;
        this.tail = tail;
    }
}

