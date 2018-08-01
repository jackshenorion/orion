package com.shenpinyi.cracking.question1_8;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {
                        5, 4, 3, 1
                },
                {
                        3, 0, 2, 2
                },
                {
                        0, 1, 3, 0
                },
                {
                        4, 5, 6, 7
                }
        };
        solution.print(matrix);
        solution.run(matrix);
        solution.print(matrix);

    }

    private void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private void run(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        init(rows);
        init(columns);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void init(boolean[] checkResult) {
        for (int i = 0; i < checkResult.length; i++) {
            checkResult[i] = false;
        }
    }
}
