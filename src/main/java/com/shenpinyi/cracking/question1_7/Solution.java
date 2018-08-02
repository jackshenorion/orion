package com.shenpinyi.cracking.question1_7;

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
        solution.run(matrix);
    }

    private void run(int[][] matrix) {
        print(matrix);
        for (int i = 0; i < matrix.length - 1; i ++) {
            for (int j = i + 1; j < matrix.length; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);

        for (int i = 0; i < matrix.length / 2; i ++) {
            for (int j = 0; j < matrix.length; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
        print(matrix);
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

}
