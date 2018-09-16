package com.shenpinyi.lintcode.linkedlist.question99;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // split the list into 2 list
        ListNode mid = getMidNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        // reverse right list
        right = reverseList(right);
        // merge 2 lists together
        merge(left, right);
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null) {
            tail.next = left;
            tail = left;
            left = left.next;
            tail.next = right;
            tail = right;
            right = right.next; ;
        }
        ListNode rest = left == null ? right : left;
        tail.next = rest;
        return dummy.next;
    }


}
