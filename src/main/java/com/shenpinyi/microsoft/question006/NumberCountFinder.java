package com.shenpinyi.microsoft.question006;

import java.util.Arrays;

/**
 * Created by jack on 6/03/2017.
 */
public class NumberCountFinder {
    private boolean flag = false;
    private int n;
    private int[] a, b;

    public NumberCountFinder(int[] a) {
        this.a = a;
        this.b = new int[a.length];
        Arrays.fill(b, 0);
        this.n = a.length;
    }

    public NumberCountFinder(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        this.n = a.length;
    }
    private int count(int index) {
        int result = 0;
        int temp = a[index];
        for (int i = 0; i < n; i++)
            if (b[i] == temp)
                result++;
        return result;
    }

    private boolean check() {
        boolean result = true;
        for (int i = 0; i < n; i++)
        {
            int sum = count(i);
            if (sum != b[i])
            {
                result = false;
                break;
            }
        }
        return result;
    }

    public void find()
    {
        print(a);
        print(b);
        while (!flag)
        {
            for (int i = 0; i < n; i++)
            {
                int sum = count(i);
                b[i] = sum;
                if (check())
                    break;
            }
            print(b);
            flag = check();
        }
    }

    private void print(int a[]) {
        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
