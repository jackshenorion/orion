package com.shenpinyi.lintcode.linkedlist.question36;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // m starts from 1, n ends length
        // get the node exactly before m
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeM = dummy;
        int pos = 0;
        while (pos + 1 < m && beforeM.next != null) {
            beforeM = beforeM.next;
            pos++;
        }
        if (beforeM == null || beforeM.next == null) {
            return head;
        }
        // reverse the nodes between m and n
        ListNode internalDummy = new ListNode(0);
        int count = 0; // nodes processed
        ListNode currentNode = beforeM.next;
        ListNode lastInternalNode = currentNode;
        while(count <= n - m + 1 && currentNode != null) {
            count++;
            ListNode nextNode = currentNode.next;
            currentNode.next = internalDummy.next;
            internalDummy.next = currentNode;
            currentNode = nextNode;
        }
        // link the first part with the inner part
        beforeM.next = internalDummy.next;
        // link the the last node of inner list to the node after n’s node
        lastInternalNode.next = currentNode;
        return dummy.next;
    }

}
