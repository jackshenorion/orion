package com.shenpinyi.atlassian.cityhorizon;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] buildings = new int[][] {
                {20, 60, 300}, // start, end, height
                {10, 50, 100},
                {5, 50, 400}
        };
        long result = solution.calcSkylineArea(buildings);
        System.out.println(result);
    }

    private long calcSkylineArea(int[][] buildings) {
        List<Integer> discretePoints = discrete(buildings);
        int[] skyline = getSkyline(buildings, discretePoints);
        return getSkylineArea(skyline, discretePoints);
    }

    private List<Integer> discrete(int[][] buildings) {
        Set<Integer> pointsSet = new HashSet<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            pointsSet.add(building[0]);
            pointsSet.add(building[1]);
        }
        ArrayList<Integer> points = new ArrayList<>(pointsSet);
        Collections.sort(points);
        return points;
    }


    private int[] getSkyline(int[][] buildings, List<Integer> discretePoints) {
        int[] skyline = new int[discretePoints.size() - 1];
        for (int i = 0; i < skyline.length; i++) {
            skyline[i] = 0;
        }

        Map<Integer, Integer> pointMap = new HashMap<>();
        for (int i = 0; i < discretePoints.size(); i++) {
            pointMap.put(discretePoints.get(i), i);
        }

        for (int i = 0; i < buildings.length; i ++) {
            int[] building = buildings[i];
            int startPoint = building[0];
            int endPoint = building[1];
            int startPointDiscrete = pointMap.get(startPoint);
            int endPointDiscrete = pointMap.get(endPoint);
            for (int point = startPointDiscrete; point < endPointDiscrete; point ++ ) {
                int originalHeight = skyline[point];
                int buildingHeight = building[2];
                if (buildingHeight > originalHeight) {
                    skyline[point] = buildingHeight;
                }
            }
        }
        return skyline;
    }

    private long getSkylineArea(int[] skyline, List<Integer> discretePoints) {
        int area = 0;
        for (int i = 0; i < skyline.length; i++) {
            int height = skyline[i];
            int length = discretePoints.get(i + 1) - discretePoints.get(i);
            area += height * length;
        }
        return area;
    }
}
