package com.shenpinyi.algorithms.sorting.linearsort;

public class RadixSort {

    public void sort(String[] a) {
        int width = 0;
        for (String s : a) {
            width = Math.max(width, s.length());
        }
        String[] b = new String[a.length];
        String[] source = a;
        String[] target = b;
        for (int i = 0; i < width; i++) {
            countingSort(source, target, i);
            String[] temp = source;
            source = target;
            target = temp;
        }
        if (source != a) {
            System.arraycopy(source, 0, a, 0, a.length);
        }
    }

    public void countingSort(String[] a, String[] b, int radix) {
        int[] c = new int[255];
        for (String s : a) {
            if (s.length() < radix + 1) {
                c[0]++;
            } else {
                c[s.charAt(s.length() - radix - 1)]++;
            }
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            String s = a[i];
            if (s.length() < radix + 1) {
                b[c[0] - 1] = s;
                c[0]--;
            } else {
                b[c[s.charAt(s.length() - radix - 1)] - 1] = s;
                c[s.charAt(s.length() - radix - 1)]--;
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"COWE", "DOGA", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB",
                "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
        new RadixSort().sort(a);
        for (String s : a) {
            System.out.print(s + " ");
        }
    }

}
