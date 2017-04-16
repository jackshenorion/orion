package com.shenpinyi.leecode.question149;

/**
 * Created by jack on 15/04/2017.
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {

    /**
     * 这个实现打败了97%的提交, 有几点值得提到的ideas:
     * 1 使用组合的思路遍历,因为每个组合都不同,所以避免遍历重复的边。
     * 2 外层循环每次挑选一个点作为start point, 后续循环就不用这个start point了。因为,如果后续循环的最优解如果包含之前的start point,
     * 那么在之前遍历这个start point时候就回得到最优解了
     * 3 因为浮点数有精度问题, 所以使用GCD求解二元一次方程的最小系数(建立在点坐标都是整数的基础上),这样同一条线的Line对象才能具有相同的
     * 系数,有相同的hashcode,这样才可以使用hashMap来组织Line,快速的找到相同的Line以便计数
     * 4 HashMap的hashcode算法必须要保证equals方法认为相同的对象有相同的hashcode,这样它们才会在一个bucket里面,否则equals就没意义了
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        int n = points.length;
        int result = 0;
        if (points.length == 1) {
            return 1;
        }
        for (int i = 0; i < n - 1; i ++) {
            HashMap<Line, Integer> lineMap = new HashMap<>();
            Point startPoint = points[i];
            int maxCount = 1;
            int overlap = 0;
            for (int j = i + 1; j < n; j ++) {
                Point endPoint = points[j];
                if (startPoint.x == endPoint.x && startPoint.y == endPoint.y) {
                    overlap ++;
                    continue;
                }
                Line line = getLine(startPoint, endPoint);
                Integer count = lineMap.get(line);
                if (count == null) {
                    count = 2;
                    lineMap.put(line, count);
                } else {
                    count ++;
                    lineMap.put(line, count);
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            result = Math.max(result, maxCount + overlap);
        }

        return result;
    }

    private Line getLine(Point p1, Point p2) {
        int a = p2.y - p1.y;
        int b = p1.x - p2.x;
        int c = p1.x * p2.y - p2.x * p1.y;
        int gcd = generateGCD(a, b, c);

        return new Line(
            a / gcd,
            b / gcd,
            c / gcd
        );
    }

    private int generateGCD(int a, int b, int c) {
        int d = generateGCD(a, b);
        return generateGCD(d, c);
    }

    private int generateGCD(int a,int b){

        if (b==0) return a;
        else return generateGCD(b,a%b);

    }

    class Line {
        int a;
        int b;
        int c;
        Line(int a, int b, int c) {this.a = a; this.b = b; this.c = c;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (a * line.c != line.a * c) return false;
            if (a * line.b != line.a * b) return false;
            return b * line.c == line.b * c;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }

}
