package com.shenpinyi.other.airtasker.rate_limiting.impl;

import com.shenpinyi.other.airtasker.rate_limiting.RateLimiter;

public class RateLimiterDummyImpl implements RateLimiter {
    @Override
    public long tillToOpenInSeconds(String requester) {
        return 0;
    }
}
