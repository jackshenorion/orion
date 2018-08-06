package com.shenpinyi.concurrency.memoize;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Function<Long, Boolean> primeMemoizer = new Memoizer<>(PrimeChecker::bruteForceChecker);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Boolean>> futureList = new Random()
                .longs(20, 0, 10)
                .mapToObj(ranNum -> new PrimeCallable(ranNum, primeMemoizer))
                .map(executorService::submit)
                .collect(Collectors.toList());

        for (Future<Boolean> future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
