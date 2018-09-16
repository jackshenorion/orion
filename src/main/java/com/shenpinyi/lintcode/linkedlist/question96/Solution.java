package com.shenpinyi.lintcode.linkedlist.question96;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummyRight = new ListNode(0);
        ListNode dummyLeft = new ListNode(0);
        ListNode rightLast = dummyRight;
        ListNode leftLast = dummyLeft;
        ListNode last = head;
        while (last != null) {
            if (last.val < x) {
                leftLast.next = last;
                leftLast = leftLast.next;
            } else {
                rightLast.next = last;
                rightLast = rightLast.next;
            }
            last = last.next;
        }
        leftLast.next = dummyRight.next;
        return dummyLeft.next;

    }
}
