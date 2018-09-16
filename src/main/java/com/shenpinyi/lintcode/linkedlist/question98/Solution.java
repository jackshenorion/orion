package com.shenpinyi.lintcode.linkedlist.question98;

import com.shenpinyi.lintcode.linkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedHashMap;

public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // split list into 2
        ListNode midNode = findMidNode(head);
        ListNode left = head;
        ListNode right = midNode.next;
        midNode.next = null;
        // get sorted list of these 2 list
        ListNode sortedLeftHead = sortList(left);
        ListNode sortedRightHead = sortList(right);
        // merge these 2 sorted list
        ListNode newDummy = new ListNode(0);
        ListNode newListLast = newDummy;
        while(sortedLeftHead != null && sortedRightHead != null) {
            if (sortedLeftHead.val <= sortedRightHead.val) {
                newListLast.next = sortedLeftHead;
                sortedLeftHead = sortedLeftHead.next;
            } else {
                newListLast.next = sortedRightHead;
                sortedRightHead = sortedRightHead.next;
            }
            newListLast = newListLast.next;
        }
        ListNode restHead = sortedLeftHead != null ? sortedLeftHead : sortedRightHead;
        while(restHead != null) {
            newListLast.next = restHead;
            restHead = restHead.next;
            newListLast = newListLast.next;
        }
        return newDummy.next;
    }

    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }


}
