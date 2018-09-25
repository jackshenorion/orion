package com.shenpinyi.lintcode.arraynumbers.question57;

import java.util.*;

public class Solution {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int first = numbers[i];
            int target = -first;
            int secondIndex = i + 1;
            int thirdIndex = numbers.length - 1;
            while (secondIndex < thirdIndex) {
                if (secondIndex > i + 1 && numbers[secondIndex] == numbers[secondIndex - 1]) {
                    secondIndex++;
                    continue;
                }
                if (thirdIndex < numbers.length - 1 && numbers[thirdIndex] == numbers[thirdIndex + 1]) {
                    thirdIndex--;
                    continue;
                }
                int sum = numbers[secondIndex] + numbers[thirdIndex];
                if (sum == target) {
                    result.add(Arrays.asList(first, numbers[secondIndex], numbers[thirdIndex]));
                    secondIndex++;
                    thirdIndex--;
                } else if (sum < target) {
                    secondIndex ++;
                } else {
                    thirdIndex --;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumB(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            int target = -numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    Pair pair = new Pair(numbers[i], numbers[left]);
                    if (!pairs.contains(pair)) {
                        pairs.add(pair);
                        result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    }
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first &&
                    second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

}
