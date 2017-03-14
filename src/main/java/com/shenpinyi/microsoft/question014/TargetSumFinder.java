package com.shenpinyi.microsoft.question014;

public class TargetSumFinder {
    public static void find(int a[], int target) {
        if (a == null || a.length == 0) {
            System.out.println("Input is empty!");
            return;
        }
        int lower = 0;
        int upper = a.length - 1;
        while (lower != upper) {
            int sum = a[lower] + a[upper];
            if (sum == target) {
                System.out.print(String.format("Found it, a[%d] = %d and a[%d] = %d",
                    lower, a[lower], upper, a[upper]));
                return;
            } else if (sum > target) {
                upper--;
            } else {
                lower ++;
            }
        }
    }

}
