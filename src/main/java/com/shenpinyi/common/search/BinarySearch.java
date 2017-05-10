package com.shenpinyi.common.search;

/**
 * Created by jack on 3/05/2017.
 */
public class BinarySearch {

    public static int run(int[] a, int target) {
        /**
         * 注意点:
         * 1 二分查询返回的是和target相等的值的索引,而不是target值。所以可以定义如果没找到,就返回索引值未-1
         */
        if (a == null || a.length == 0) {
            return -1;
        } else {
            return helper(a, target, 0, a.length - 1);
        }
    }

    private static int helper(int[]a, int target, int start, int end) {
        if (start > end) {return -1;} // Warning: 一定要有这个判断,假设start 和end在前一轮相等,那么mid就start,如果mid的值比target小,那么就会将start的值赋为mid+1,于是start就比end大了
        int mid = start + ((end - start) / 2); // Warning: 如果start和end都很大,如果使用(start+end)/2中的start+end有可能会溢出
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return helper(a, target, start, mid - 1);
        } else {
            return helper(a, target, mid + 1, end); //Warning: 一定要 mid + 1, 否则会死循环,比如就两个数4,6,找5.每次就是start=0, end=1
        }
    }

    public static void main(String[] args) {
        System.out.println(run(new int[]{}, 1));
        System.out.println(run(new int[]{1,2,3,4,5,6}, 1));
        System.out.println(run(new int[]{1,2,3,4,5,6}, 6));
        System.out.println(run(new int[]{1,2,3,4,5,6}, 0));
        System.out.println(run(new int[]{1,2,3,4,5,6}, 7));
        System.out.println(run(new int[]{1,2,3,4,5,6}, 2));

    }
}
