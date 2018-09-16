package com.shenpinyi.lintcode.linkedlist.question105;

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode current = head;
        // insert the new node behind each old node
        while(current != null) {
            RandomListNode newNode = new RandomListNode(current.label);
            newNode.next = current.next;
            newNode.random = current.random;
            RandomListNode temp = current;
            current = current.next;
            temp.next = newNode;
        }
        // replace the newNode.random with newNode
        current = head;
        while(current != null) {
            RandomListNode newNode = current.next;
            if (newNode.random != null) {
                newNode.random = newNode.random.next;
            }
            current = current.next.next;
        }
        // then we split the list into two
        RandomListNode oldDummy = new RandomListNode(0);
        RandomListNode newDummy = new RandomListNode(0);
        RandomListNode last = head;
        RandomListNode oldLast = oldDummy;
        RandomListNode newLast = newDummy;
        while(last != null) {
            oldLast.next = last;
            newLast.next = last.next;
            last = last.next.next;
            oldLast = oldLast.next;
            newLast = newLast.next;
        }
        oldLast.next = null;
        newLast.next = null;
        return newDummy.next;
    }
}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};