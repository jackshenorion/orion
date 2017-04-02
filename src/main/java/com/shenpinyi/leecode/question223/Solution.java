package com.shenpinyi.leecode.question223;

/**
 * Created by jack on 30/03/2017.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int maxx1 = A < E ? E : A;
        int minx2 = C < G ? C : G;
        int maxy1 = B < F ? F : B;
        int miny2 = D < H ? D : H;

        if (maxx1 < minx2 && maxy1 < miny2) {
            return (C - A) * (D - B) + (G - E) * (H - F) - (minx2 - maxx1) * (miny2 - maxy1);
        } else {
            return (C - A) * (D - B) + (G - E) * (H - F);
        }
    }
}
