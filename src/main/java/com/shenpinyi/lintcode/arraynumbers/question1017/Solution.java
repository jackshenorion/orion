package com.shenpinyi.lintcode.arraynumbers.question1017;

import java.util.Map;

public class Solution {

    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
        if (color.length() == 4) {
            return color;
        }
        String a = getClosest(Integer.valueOf(color.substring(1,3), 16));
        String b = getClosest(Integer.valueOf(color.substring(3,5), 16));
        String c = getClosest(Integer.valueOf(color.substring(5,7), 16));
        return "#" + a + b + c;
    }

    private String getClosest(int number) {
        int i = 0;
        while (i < 16 && Math.abs(i * 16 + i - number) > Math.abs((i + 1) * 16 + i + 1 - number)) {
            i++;
        }
        return Integer.toHexString(i) + "" + Integer.toHexString(i);
    }

}
