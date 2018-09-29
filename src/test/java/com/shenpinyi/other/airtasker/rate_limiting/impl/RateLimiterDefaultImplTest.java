package com.shenpinyi.other.airtasker.rate_limiting.impl;

import com.shenpinyi.other.airtasker.rate_limiting.RateLimiter;
import com.shenpinyi.other.airtasker.rate_limiting.RateLimiterFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateLimiterDefaultImplTest {

    @Test
    public void limiterForOneClient() {
        int durationInSeconds = 10;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        for (int i = 0; i < limit; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        }
        assertTrue(rateLimiter.tillToOpenInSeconds(client) > 0);
        assertTrue(rateLimiter.tillToOpenInSeconds(client) > 0);
    }

    @Test
    public void limierForMultipleClients() {
        int durationInSeconds = 10;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String clientA = "clientA";
        String clientB = "clientB";
        for (int i = 0; i < limit; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(clientA));
            assertEquals(0, rateLimiter.tillToOpenInSeconds(clientB));
        }
        assertTrue(rateLimiter.tillToOpenInSeconds(clientA) > 0);
        assertTrue(rateLimiter.tillToOpenInSeconds(clientB) > 0);
    }

    @Test
    public void limiterTillOpenTime() throws InterruptedException {
        int durationInSeconds = 10;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        for (int i = 0; i < limit; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        }
        Thread.sleep(durationInSeconds * 1000);
        assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
    }

    @Test
    public void requestInSteadyPaces() throws InterruptedException {
        int durationInSeconds = 10;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        for (int i = 0; i < limit * 3; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
            Thread.sleep(durationInSeconds * 1000 / limit);
        }
    }

    @Test
    public void movingTillOpenInSeconds() throws InterruptedException {
        int durationInSeconds = 10;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        //[1_1_1_1_1_]
        for (int i = 0; i < 5; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
            Thread.sleep(1000);
        }
        // [1_1_1_1_1_5_]
        for (int i = 0; i < 5; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        }
        Thread.sleep(1000);
        // [1_1_1_1_1_5_0_0_0_0_1_1]
        assertEquals(4, rateLimiter.tillToOpenInSeconds(client));
        Thread.sleep(1000);
        assertEquals(3, rateLimiter.tillToOpenInSeconds(client));
        Thread.sleep(1000);
        assertEquals(2, rateLimiter.tillToOpenInSeconds(client));
        Thread.sleep(1000);
        assertEquals(1, rateLimiter.tillToOpenInSeconds(client));
        Thread.sleep(1000);
        assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        Thread.sleep(1000);
        assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
    }


    @Test
    public void oneSecondLimiter() throws InterruptedException {
        int durationInSeconds = 1;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        for (int k = 0; k < 5; k++) { // run 5 rounds
            for (int i = 0; i < limit; i++) {
                assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
            }
            assertEquals(1, rateLimiter.tillToOpenInSeconds(client));
            Thread.sleep(1000);
        }
    }

    @Test
    public void dummyLimiter() {
        int durationInSeconds = 0;
        int limit = 0;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        String client = "client";
        for (int i = 0; i < 100; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
        }
    }

    @Test
    public void setABSwitch() throws InterruptedException {
        int durationInSeconds = 5;
        int limit = 10;
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(durationInSeconds, limit);
        ((RateLimiterDefaultImpl) rateLimiter).setSwitchDurationInSeconds(5);
        String client = "client";
        for (int i = 0; i < limit * 3; i++) {
            assertEquals(0, rateLimiter.tillToOpenInSeconds(client));
            Thread.sleep(durationInSeconds * 1000 / limit);
        }
    }

}