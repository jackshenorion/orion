package com.shenpinyi.lintcode.linkedlist.question106;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {

    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode first = new TreeNode(head.val);
            TreeNode second = new TreeNode(head.next.val);
            first.right = second;
            return first;
        }
        // find the middle node
        ListNode midPre = findMiddlePre(head);
        // split list into 2
        ListNode left = head;
        ListNode right = midPre.next.next;
        TreeNode root = new TreeNode(midPre.next.val);
        midPre.next = null;
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }

    private ListNode findMiddlePre(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
