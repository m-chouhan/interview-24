package lld.atlassian_backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateLimiterTest {

    RateLimiter subject;
    @Before
    public void setUp() throws Exception {
        subject = new RateLimiter(1, 1000);
    }

    @Test
    public void rateLimitEmptyScenario() {
        subject =  new RateLimiter(0, 0);
        assertFalse(subject.rateLimit(100));
        assertFalse(subject.rateLimit(200));
    }

    @Test
    public void rateLimitTest1() {
        assertTrue(subject.rateLimit(100));
        assertFalse(subject.rateLimit(100));
    }

    @Test
    public void rateLimitTest2() throws InterruptedException {
        assertTrue(subject.rateLimit(100));
        assertTrue(subject.rateLimit(200));
        Thread.sleep(1000);
        assertTrue(subject.rateLimit(100));
        assertTrue(subject.rateLimit(200));
    }

    @Test
    public void rateLimitTestBurstyTraffic() throws InterruptedException {
        subject = new RateLimiter(2, 5000);
        assertTrue(subject.rateLimit(100));
        assertTrue(subject.rateLimit(100));
        Thread.sleep(4000);
        assertFalse(subject.rateLimit(100));
        assertFalse(subject.rateLimit(100));
        Thread.sleep(1500);
        assertTrue(subject.rateLimit(100));
    }
}