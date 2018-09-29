package com.shenpinyi.other.airtasker.rate_limiting;

public interface RateLimiter {
    long tillToOpenInSeconds(String requester);
}
