package com.shenpinyi.concurrency.memoize;

import java.util.concurrent.*;
import java.util.function.Function;

public class Memoizer<T, R> implements Function<T, R> {

    private Function<T, R> mFunction;
    private ConcurrentMap<T, Future<R>> mCache = new ConcurrentHashMap<>();

    public Memoizer(Function<T, R> function) {
        this.mFunction = function;
    }

    @Override
    public R apply(T t) {
        Future<R> future = mCache.get(t);
        if (future == null) {
            future = computeValue(t);
        }
        return getFutureValue(t, future);
    }

    public Future<R> computeValue(T t) {
        FutureTask<R> futureTask = new FutureTask<>(() -> mFunction.apply(t));
        Future<R> future = mCache.putIfAbsent(t, futureTask);
        if (future != null) {
            return future;
        } else {
            futureTask.run();
            return futureTask;
        }
    }

    public R getFutureValue(T t, Future<R> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
