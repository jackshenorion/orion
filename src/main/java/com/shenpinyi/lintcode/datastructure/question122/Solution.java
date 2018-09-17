package com.shenpinyi.lintcode.datastructure.question122;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        int largestArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty()) {
                stack.push(new Node(height[i], i));
            } else {
                Node newNode = new Node(height[i], i);
                while (!stack.empty()) {
                    Node current = stack.peek();
                    if (current.height == newNode.height) {
                        newNode = null;
                        break;
                    } else if (current.height < newNode.height) {
                        break;
                    } else {
                        current = stack.pop();
                        largestArea = Math.max(largestArea, current.height * (i - current.start));
                        newNode.start = current.start;
                    }
                }
                if (newNode != null) {
                    stack.push(newNode);
                }
            }
        }

        while (!stack.isEmpty()) {
            Node lastNode = stack.pop();
            largestArea = Math.max(largestArea, lastNode.height * (height.length - lastNode.start));
        }
        return largestArea;
    }

    public int largestRectangleAreaQueue(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        Queue<Node> heights = new LinkedList<>();
        Node lastNode = null;
        int largestArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (lastNode == null) {
                lastNode = new Node(height[i], i);
                heights.offer(lastNode);
            } else {
                if (lastNode.height == height[i]) {
                    continue;
                } else if (lastNode.height < height[i]) {
                    lastNode = new Node(height[i], i);
                    heights.offer(lastNode);

                } else {
                    int count = 0;
                    lastNode = null;
                    while (count < heights.size()) {
                        Node current = heights.poll();
                        if (current.height > height[i]) {
                            largestArea = Math.max(largestArea, current.height * (i - current.start));
                            current.height = height[i];
                        }
                        if (lastNode != null && lastNode.height == current.height) {
                            continue;
                        }
                        heights.offer(current);
                        lastNode = current;
                        count++;
                    }
                }
            }
        }
        while (!heights.isEmpty()) {
            lastNode = heights.poll();
            largestArea = Math.max(largestArea, lastNode.height * (height.length - lastNode.start));
        }
        return largestArea;
    }

    class Node {
        int height;
        int start;

        public Node(int height, int start) {
            this.height = height;
            this.start = start;
        }
    }

    public int largestRectangleAreaOutOfTimeLimit(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int[] minHeight = new int[height.length];
        minHeight[0] = height[0];
        int largestArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j ++) {
                if (i == j) {
                    minHeight[i] = height[i];
                } else {
                    minHeight[j] = Math.min(minHeight[j - 1], height[j]);
                }
                largestArea = Math.max(largestArea, minHeight[j] * (j - i + 1));
            }
        }
        return largestArea;
    }
}
