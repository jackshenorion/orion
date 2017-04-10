package com.shenpinyi.leecode.question109;

/**
 * Created by jack on 8/04/2017.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {return null;}
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode tail) {
        ListNode fast = head, slow = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);
        return root;

    }

    public TreeNode sortedListToBST_B(ListNode head) {
        if (head == null) {return null;}
        ListNode node = head;
        List<Integer> nodes = new ArrayList(2048);
        while (node != null) {
            nodes.add(node.val);
            node = node.next;
        }
        return build(nodes, 0, nodes.size() - 1);
    }

    private TreeNode build(List<Integer> nodes, int start, int end) {
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nodes.get(mid));
        if (start < mid) {
            root.left = build(nodes, start, mid - 1);
        }

        if (end > mid) {
            root.right = build(nodes, mid + 1, end);
        }
        return root;
    }

    public TreeNode sortedListToBST_A(ListNode head) {
        if (head == null) {return null;}
        ListNode node = head;
        List<Integer> nodes = new ArrayList();
        while (node != null) {
            nodes.add(node.val);
            node = node.next;
        }
        return build_b(nodes, 0, nodes.size() - 1);
    }

    private TreeNode build_b(List<Integer> nodes, int start, int end) {
        int mid = findRoot(start, end);
        TreeNode root = new TreeNode(nodes.get(mid));
        if (start < mid) {
            root.left = build_b(nodes, start, mid - 1);
        }

        if (end > mid) {
            root.right = build_b(nodes, mid + 1, end);
        }
        return root;
    }

    private int findRoot(int start, int end) {
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
