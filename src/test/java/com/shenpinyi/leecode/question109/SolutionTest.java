package com.shenpinyi.leecode.question109;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 8/04/2017.
 */
public class SolutionTest {

    @Test
    public void testSortedListToBST() throws Exception {
        int[] a = new int[16000];
        for (int i = 0; i < 16000; i++) {
            a[i] = i - 1000;
        }

        printTree(new Solution().sortedListToBST(buildList(a)));
    }

    private ListNode buildList(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode pre = head;
        for (int i = 1; i < a.length; i++) {
            ListNode current = new ListNode(a[i]);
            pre.next = current;
            pre = current;
        }
        return head;
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }


    private int findRoot(int[] a, int start, int end) {
        int len = end - start + 1;
        int n = 0;
        while (((1 << n) - 1) < len) {
            n++;
        }
        if (len == 1) {
            return start;
        } else if (len == 2) {
            return start;
        } else if (len == 3) {
            return start + 1;
        } else {
            return start + Math.min(len - (1 << (n - 2)), (1 << (n - 1)) - 1);
        }
    }
}