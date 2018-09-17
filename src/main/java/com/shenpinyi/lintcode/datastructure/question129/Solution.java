package com.shenpinyi.lintcode.datastructure.question129;

import com.shenpinyi.lintcode.linkedlist.ListNode;

public class Solution {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null) {
            return null;
        }
        int capacity = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                ListNode current = node;
                node = node.next;
                current.next = null;
                int value = current.val;
                int hash = value % capacity;
                hash = hash < 0 ? hash + capacity : hash;
                ListNode newHead = newHashTable[hash];
                if (newHead == null) {
                    newHashTable[hash] = current;
                } else {
                    while (newHead.next != null) {
                        newHead = newHead.next;
                    }
                    newHead.next = current;
                }
            }
        }
        return newHashTable;
    }

}

