package com.shenpinyi.atlassian.basket;

import java.util.*;

public class Solution {
    /**
     * The problem is there're multiple transactions.
     * each transaction has several fruit
     * provide a function, given a combination of fruits, you can provide the number of transactions
     * which have this combination of fruits
     */


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addTransaction(Arrays.asList("apple", "orange", "banana"));
        solution.addTransaction(Arrays.asList("apple", "kiwi"));
        int c1 = solution.count(Arrays.asList("apple"));
        int c2 = solution.count(Arrays.asList("orange", "banana"));
        int c3 = solution.count(Arrays.asList("orange", "kiwi"));
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    private Solution addTransaction(List<String> fruits) {

        // get power set of these fruits
        Set<Set<String>> powerSet = getPowerSet(fruits);
        // add each of these set to static
        for (Set<String> set : powerSet) {
            addCount(set);
        }
        return this;
    }

    private void addCount(Set<String> set) {
        statistics.putIfAbsent(set, 0);
        statistics.put(set, statistics.get(set) + 1);
    }

    private Set<Set<String>> getPowerSet(List<String> fruits) {
        // from 1 to size
        // use current set, then plus a fruit on each set
        Set<Set<String>> powerSet = new HashSet<>();
        for (int i = 0; i < fruits.size(); i++) {
            Set<Set<String>> additionalPowerSet = new HashSet<>();
            String currentFruit = fruits.get(i);
            for (Set<String> set : powerSet) {
                HashSet<String> newSet = new HashSet<>(set);
                newSet.add(currentFruit);
                additionalPowerSet.add(Collections.unmodifiableSet(newSet));
            }
            HashSet<String> newSet = new HashSet<>();
            newSet.add(currentFruit);
            additionalPowerSet.add(Collections.unmodifiableSet(newSet));
            powerSet.addAll(additionalPowerSet);
        }
        return powerSet;
    }

    private Map<Set<String>, Integer> statistics = new HashMap<>();

    private int count(List<String> fruits) {
        HashSet<String> set = new HashSet<>(fruits);
        return statistics.getOrDefault(set, 0);
    }
}
