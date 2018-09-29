package com.shenpinyi.other.airtasker.rate_limiting.impl;

import com.shenpinyi.other.airtasker.rate_limiting.RateLimiter;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

public class RateLimiterDefaultImpl implements RateLimiter {
    private final static Logger logger = Logger.getLogger(RateLimiterDefaultImpl.class.getName());
    private final static int MIN_SWITCH_DURATION_SECONDS = 3600;

    private Map<String, Queue<Long>>[] requesterToRatesWithABSwitch; // use AB switch to purge all outdated rates
    private int currentSwitch;
    private int switchDurationInSeconds;
    private int durationInSeconds;
    private int limit;

    public RateLimiterDefaultImpl(int durationInSeconds, int limit) {
        this.durationInSeconds = durationInSeconds;
        this.switchDurationInSeconds = Math.max(MIN_SWITCH_DURATION_SECONDS, durationInSeconds);
        this.limit = limit;
        this.requesterToRatesWithABSwitch = new Map[2];
        this.requesterToRatesWithABSwitch[0] = new ConcurrentHashMap<>();
        this.requesterToRatesWithABSwitch[1] = new ConcurrentHashMap<>();
        this.currentSwitch = 0;
    }

    public void setSwitchDurationInSeconds(int switchDurationInSeconds) {
        // if default AB switch seconds is too long to hold all of the requesters,
        // reduce the switch duration, but it cannot be less than measure duration
        this.switchDurationInSeconds = Math.max(switchDurationInSeconds, durationInSeconds);
    }

    @Override
    public long tillToOpenInSeconds(String requester) {
        long currentTimeInMilliSeconds = System.currentTimeMillis();
        long beginOfWindowInMilliSeconds = currentTimeInMilliSeconds - durationInSeconds * 1000;
        Queue<Long> rate = getRate(requester);
        while (!rate.isEmpty() && rate.peek() < beginOfWindowInMilliSeconds) {
            rate.poll();
        }
        if (rate.size() < limit) {
            rate.offer(currentTimeInMilliSeconds);
            return 0;
        } else {
            while (rate.size() > limit) { // poll until there're only limit of timestamps in queue
                rate.poll();
            }
            beginOfWindowInMilliSeconds = rate.peek();
            return Math.round((beginOfWindowInMilliSeconds + durationInSeconds * 1000 - currentTimeInMilliSeconds) / 1000.0);
        }
    }

    private Queue<Long> getRate(String requester) {
        checkAndUpdateCurrentSwitch();
        Map<String, Queue<Long>> currentRates = requesterToRatesWithABSwitch[currentSwitch];
        Map<String, Queue<Long>> historicalRates = requesterToRatesWithABSwitch[(currentSwitch + 1) % 2];
        if (!currentRates.containsKey(requester)) {
            if (historicalRates.containsKey(requester)) {
                currentRates.putIfAbsent(requester, historicalRates.get(requester));
            } else {
                currentRates.putIfAbsent(requester, new LinkedBlockingDeque<>());
            }
        }
        return currentRates.get(requester);
    }

    private void checkAndUpdateCurrentSwitch() {
        long currentTimeInSeconds = System.currentTimeMillis() / 1000;
        int targetSwitch = (int) ((currentTimeInSeconds / this.switchDurationInSeconds) % 2);
        if (targetSwitch != currentSwitch) {
            logger.info("RateLimiterDefaultImpl rates map is switched." +
                    "From switch: " + currentSwitch +
                    " to switch: " + targetSwitch +
                    " from size: " + requesterToRatesWithABSwitch[currentSwitch].size());
            synchronized (this) {
                this.requesterToRatesWithABSwitch[targetSwitch] = new ConcurrentHashMap<>(); // purge outdated rates
                this.currentSwitch = targetSwitch;
            }
        }
    }
}