package com.shenpinyi.lintcode.graph.question433;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] adjI = new int[]{-1, 1, 0, 0};
        int[] adjJ = new int[]{0, 0, -1, 1};
        int[] parent = new int[rows * cols];
        initParent(parent);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                int index = getIndex(i, j, cols);
                for (int k = 0; k < 4; k++) {
                    int indexI = adjI[k] + i;
                    int indexJ = adjJ[k] + j;
                    if (inbound(indexI, indexJ, rows, cols) && grid[indexI][indexJ]) {
                        join(parent, index, getIndex(indexI, indexJ, cols));
                    }
                }
            }
        }
        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                int index = getIndex(i, j, cols);
                int p = findParent(parent, index);
                islands.add(p);
            }
        }
        return islands.size();
    }

    private void initParent(int[] parent) {
        for (int i = 0; i < parent.length; i++ ) {
            parent[i] = i;
        }
    }

    private void join(int[] parent, int source, int target) {
        int sourceParent = findParent(parent, source);
        int targetParent = findParent(parent, target);
        if (sourceParent != targetParent) {
            parent[targetParent] = sourceParent;
        }
    }

    private int findParent(int[] parent, int index) {
        int current = index;
        while (parent[current] != current) {
            current = parent[current];
        }
        int comp = index;
        while (parent[comp] != comp) {
            int next = parent[comp];
            parent[comp] = current;
            comp = next;
        }
        return current;
    }

    private int getIndex(int i, int j, int cols) {
        return i * cols + j;
    }

    public int numIslandsB(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(grid, visited, i, j, rows, cols);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        if (!inbound(i, j, rows, cols)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (!grid[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j, rows, cols);
        dfs(grid, visited, i - 1, j, rows, cols);
        dfs(grid, visited, i, j + 1, rows, cols);
        dfs(grid, visited, i, j - 1, rows, cols);
    }

    private boolean inbound(int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows) {
            return false;
        }
        if (j < 0 || j >= cols) {
            return false;
        }
        return true;
    }
}
