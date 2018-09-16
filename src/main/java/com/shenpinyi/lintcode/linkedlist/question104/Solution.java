package com.shenpinyi.lintcode.linkedlist.question104;

import com.shenpinyi.lintcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Comparator<ListNode> comparator = new Comparator<ListNode> () {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), comparator);
        for(int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKListsB(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeKListsHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        if (start + 1 == end) {
            return merge(lists.get(start), lists.get(end));
        } else {
            int mid = start + (end - start) / 2;
            ListNode left = mergeKListsHelper(lists, start, mid);
            ListNode right = mergeKListsHelper(lists, mid + 1, end);
            return merge(left, right);
        }
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        ListNode rest = left == null ? right : left;
        ListNode restTail = rest;
        while (restTail != null) {
            tail.next = restTail;
            tail = tail.next;
            restTail = restTail.next;
        }
        return dummy.next;
    }


}
