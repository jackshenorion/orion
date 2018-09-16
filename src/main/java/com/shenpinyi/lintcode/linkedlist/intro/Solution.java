package com.shenpinyi.lintcode.linkedlist.intro;

public class Solution {
    public static void printList(ListNode node) {
        ListNode current = node;
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }


    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = node1;
        printList(head);
        node1 = node2;
        printList(head);
    }

}

class ListNode {
    ListNode next = null;
    int val;
    public ListNode(int v) {
        this.val = v;
    }
}
