package com.shenpinyi.lintcode.linkedlist.question450;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {

    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        // find kth node
        ListNode kthNode = findKthNode(head, k);
        // split lists into 2
        if (kthNode == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = kthNode.next;
        kthNode.next = null;
        // reverse the left part, also note the end of this list
        ListNode dummy = new ListNode(0);
        while(left != null) {
            ListNode next = left.next;
            left.next = dummy.next;
            dummy.next = left;
            left = next;
        }
        // k reverse the right part
        right = reverseKGroup(right, k);
        // connect the 2 part together
        head.next = right;
        return dummy.next;
    }


    private ListNode findKthNode(ListNode head, int k) {
        int step = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current != null && step < k) {
            step ++;
            current = current.next;
        }
        return current;
    }
}
