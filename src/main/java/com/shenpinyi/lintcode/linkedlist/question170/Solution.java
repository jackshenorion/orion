package com.shenpinyi.lintcode.linkedlist.question170;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = getLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        // get to the node - (k - 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode advance = dummy;
        ListNode behind = dummy;
        int steps = 0;
        while(steps < k && advance != null) {
            advance = advance.next;
            steps++;
        }
        if (advance == null || advance.next == null) {
            return head;
        }
        while(advance.next != null) {
            advance = advance.next;
            behind = behind.next;
        }
        ListNode newHead = behind.next;
        behind.next = null;
        advance.next = head;
        return newHead;

    }

    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
