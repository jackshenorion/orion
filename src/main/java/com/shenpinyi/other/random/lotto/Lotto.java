package com.shenpinyi.other.random.lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by jack on 31/03/2017.
 */
public class Lotto {

    public static String generate(int n, int m, int count) {
        Random r = new Random();
        StringBuilder builder = new StringBuilder();
        float f[] = new float[n];
        int[] s = new int[m];
        while (count-- > 0) {
            int[] a = IntStream.range(1, n + 1).toArray();
            int[] b = new int[m];
            int k = 0;
            while (k < m) {
                int p = r.nextInt(n - k);
                f[a[p] - 1] ++;
                b[k] = a[p];
                a[p] = a[n - k - 1];
                k++;
            }
            Arrays.sort(b);
            boolean[] smark = new boolean[m];
            int maxSeq = 1;
            int seqLast = b[0];
            int j = 1;
            while (j < m) {
                if (b[j] == seqLast + 1) {
                    maxSeq ++;
                    smark[maxSeq - 1] = true;
                } else {
                    maxSeq = 1;
                }
                seqLast = b[j];
                j++;
            }

            int q = 0;
            while (q < m) {
                if (smark[q]) {
                    s[q] ++;
                }
                q++;
            }
            //builder.append(Arrays.toString(b) + "\n");
        }
        builder.append(Arrays.toString(f) + "\n");
        builder.append(Arrays.toString(s) + "\n");
        return builder.toString();
    }
}
