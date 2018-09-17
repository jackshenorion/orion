package com.shenpinyi.lintcode.datastructure.question510;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {


    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null) {
            return 0;
        } else if (matrix.length == 0) {
            return 0;
        } else if (matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            updateHeight(heights, matrix[i]);
            max = Math.max(max, maxRectangleArea(heights));
        }
        return max;
    }
    // how to get each row’s height
    // current plus previous height
    private void updateHeight(int[] previous, boolean[] current) {
        for (int i = 0; i < current.length; i++) {
            previous[i] = current[i] ? previous[i] + 1 : 0;
        }
    }
    private int maxRectangleArea(int[] heights) {
        Deque<Rectangle> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            Rectangle currentRect = new Rectangle();
            currentRect.start = i;
            currentRect.height = current;
            while(!stack.isEmpty()) {
                Rectangle rect = stack.peek();
                if (rect.height < currentRect.height) {
                    break;
                } else {
                    rect = stack.pop();
                    int popArea = rect.height * (i - rect.start);
                    max = Math.max(max, popArea);
                    currentRect.start = rect.start;
                }
            }
            stack.push(currentRect);
        }
        while(!stack.isEmpty()) {
            Rectangle rect = stack.pop();
            int popArea = rect.height * (heights.length - rect.start);
            max = Math.max(max, popArea);
        }
        return max;
    }

    class Rectangle {
        int start = 0;
        int height = 0;
    }
}

