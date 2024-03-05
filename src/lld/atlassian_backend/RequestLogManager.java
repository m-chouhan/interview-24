package lld.atlassian_backend;

import java.util.ArrayDeque;
import java.util.Deque;

public class RequestLogManager {
    final Deque<RequestLog> requestLogs = new ArrayDeque<>();
    final int customerId;
    final CreditSystem creditSystem;
    RequestLogManager(int customerId, CreditSystem creditSystem) {
        this.customerId = customerId;
        this.creditSystem = creditSystem;
    }

}
