package lld.atlassian_backend;

// Perform rate limiting logic for provided customer ID. Return true if the
// 1. request is allowed, and false if it is not.
// 2. Each customer can make X requests per Y seconds

// Space Complexity : #customerIds * maxReqeuests (all customers)
//                     maxRequest (for inidividual customer)
//
// Time Complexity : O(1) Hash Lookpup * maxRequest (each request)

import java.util.*;

public class RateLimiter {

    private final HashMap</* customer id */ Integer, Deque<RequestLog>> requestLogs;
    final int maxRequests, windowSizeInMillis;
    public RateLimiter(int maxRequests, int windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        requestLogs = new HashMap<>();
    }

    boolean rateLimit(int customerId) {
        if(requestLogs.containsKey(customerId)) {
            Deque<RequestLog> requestLogForCustomer = requestLogs.get(customerId);
            long currentTime = System.currentTimeMillis();
            System.out.println(requestLogForCustomer.size()+ ":" + currentTime);
            while(!requestLogForCustomer.isEmpty() &&
                (currentTime - requestLogForCustomer.peekLast().timestamp) > windowSizeInMillis)
                requestLogForCustomer.removeLast();

            System.out.println(requestLogForCustomer.size());
            if(requestLogForCustomer.size() >= maxRequests) {
                return false;
            }
            requestLogForCustomer.add(new RequestLog(currentTime));
            return true;
        }
        else {
            Deque<RequestLog> queue = new ArrayDeque<>();
            RequestLog requestLog = new RequestLog(System.currentTimeMillis());
            queue.add(requestLog);
            if(queue.size() >= maxRequests) {
                return false;
            }
            requestLogs.put(customerId, queue);
            return true;
        }
    }


}
