package com.shenpinyi.lintcode.linkedlist.question113;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {
    /**
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode last = dummy;
        while(current != null && current.next != null) {
            ListNode nextNode = current.next;
            if (nextNode.val != current.val) {
                last = current;
                current = nextNode;
            } else {
                int checkVal = current.val;
                while(current != null) {
                    if (current.val == checkVal) {
                        last.next = current.next;
                        current = current.next;
                    } else {
                        break;
                    }
                }
            }
        }
        return dummy.next;
    }

}
