package com.shenpinyi.lintcode.arraynumbers.merge_sorted_array;

import com.shenpinyi.lintcode.arraynumbers.question6.SolutionB;
import org.junit.Test;

public class SolutionBTest {

    @Test
    public void mergeSortedArray() {

        int[] result = new SolutionB().mergeSortedArray(new int[]{1,2,3,4}, new int[]{2,4,5,6});
        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }
}