package com.shenpinyi.other.airtasker.rate_limiting;

import com.shenpinyi.other.airtasker.rate_limiting.impl.RateLimiterDefaultImpl;
import com.shenpinyi.other.airtasker.rate_limiting.impl.RateLimiterDummyImpl;

import java.util.logging.Logger;

public class RateLimiterFactory {
    private static final Logger logger = Logger.getLogger(RateLimiterFactory.class.getName());

    public static RateLimiter getRateLimiter(int durationInSeconds, int limit) {
        if (durationInSeconds < 0 || limit < 0) {
            throw new IllegalArgumentException("Invalid duration and limit when creating RateLimiter. " +
                    "durationInSeconds = " + durationInSeconds +
                    ", limit = " + limit);
        }
        if (durationInSeconds == 0 || limit == 0) {
            logger.info("A dummy RateLimiter is created. " +
                    "durationInSeconds = " + durationInSeconds +
                    ", limit = " + limit);
            return new RateLimiterDummyImpl();
        } else {
            logger.info("A default RateLimiter is created. " +
                    "durationInSeconds = " + durationInSeconds +
                    ", limit = " + limit);
            return new RateLimiterDefaultImpl(durationInSeconds, limit);
        }
    }
}
