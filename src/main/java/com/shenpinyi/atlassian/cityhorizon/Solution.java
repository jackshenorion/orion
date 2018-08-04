package com.shenpinyi.atlassian.cityhorizon;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] buildings = new int[][] {
                {20, 60, 300}, // start, end, height
                {10, 50, 100},
                {5, 55, 400}
        };
        solution.addBuildings(buildings);
        long result = solution.getResult();
        System.out.println(result);
    }

    private long getResult() {

        return 0;
    }

    private void addBuildings(int[][] buildings) {
    }


}
