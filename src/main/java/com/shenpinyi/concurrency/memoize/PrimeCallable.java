package com.shenpinyi.concurrency.memoize;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class PrimeCallable implements Callable<Boolean> {
    long mPrimeCandidate;
    Function<Long, Boolean> mFunction;

    PrimeCallable(long primeCandidate, Function<Long, Boolean> function) {
        this.mPrimeCandidate = primeCandidate;
        this.mFunction = function;
    }

    @Override
    public Boolean call() throws Exception {
        return mFunction.apply(mPrimeCandidate);
    }
}
