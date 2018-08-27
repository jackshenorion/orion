package com.shenpinyi.lintcode.arraynumbers.question58;

import java.util.*;

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target:  An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers.length < 4) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(numbers);
        // do it using k sum
        return kSum(numbers, 0, target, 4);
    }

    private List<List<Integer>> kSum(int[] numbers, int start, int target, int k) {
        if (k == 2) {
            List<List<Integer>> results = new LinkedList<>();
            int left = start;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (left > start && numbers[left] == numbers[left - 1]) {
                    left++;
                    continue;
                }
                if (right < numbers.length - 1 && numbers[right] == numbers[right + 1]) {
                    right--;
                    continue;
                }
                if (sum == target) {
                    List<Integer> result = new LinkedList<>();
                    result.add(numbers[left]);
                    result.add(numbers[right]);
                    results.add(result);
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return results;
        } else {
            int endIndex = numbers.length - k;
            List<List<Integer>> results = new LinkedList<>();
            for (int i = start; i <= endIndex; i++) {
                if (i > start && numbers[i] == numbers[i - 1]) {
                    continue;
                }
                int newTarget = target - numbers[i];
                List<List<Integer>> subResults = kSum(numbers, i + 1, newTarget, k - 1);
                for (List<Integer> subResult : subResults) {
                    subResult.add(0, numbers[i]);
                }
                results.addAll(subResults);
            }
            return results;
        }
    }

    public List<List<Integer>> fourSumB(int[] numbers, int target) {

        Map<Integer, List<Pair>> sumToPairs = new HashMap<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                sumToPairs.putIfAbsent(sum, new ArrayList<>());
                sumToPairs.get(sum).add(new Pair(i, j));
            }
        }
        List<List<Integer>> results = new ArrayList<>();
        HashSet<Quad> quads = new HashSet<>();
        for (Integer sum : sumToPairs.keySet()) {
            int newTarget = target - sum;
            List<Pair> pairsA = sumToPairs.get(newTarget);
            List<Pair> pairsB = sumToPairs.get(sum);
            if (pairsA == null || pairsB == null) {
                continue;
            }
            for (Pair p1 : pairsA) {
                for (Pair p2 : pairsB) {
                    int[] quad = getQuads(numbers, p1, p2);
                    if (quad != null) {
                        quads.add(new Quad(quad[0], quad[1], quad[2], quad[3]));
                    }
                }
            }
        }
        for (Quad quad : quads) {
            results.add(Arrays.asList(quad.a, quad.b, quad.c, quad.d));
        }
        return results;
    }

    private int[] getQuads(int[] numbers, Pair p1, Pair p2) {
        if (p1.indexA == p2.indexA
                || p1.indexA == p2.indexB || p1.indexB == p2.indexA || p1.indexB == p2.indexB) {
            return null;
        }
        int[] result = new int[]{numbers[p1.indexA], numbers[p1.indexB], numbers[p2.indexA], numbers[p2.indexB]};
        Arrays.sort(result);
        return result;
    }

    static class Quad {
        int a;
        int b;
        int c;
        int d;

        public Quad(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quad quad = (Quad) o;
            return a == quad.a &&
                    b == quad.b &&
                    c == quad.c &&
                    d == quad.d;
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b, c, d);
        }
    }

    static class Pair {
        int indexA;
        int indexB;

        public Pair(int indexA, int indexB) {
            this.indexA = indexA;
            this.indexB = indexB;
        }
    }

}
