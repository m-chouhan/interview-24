package lld.calendar_service;

import java.util.*;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public User getUser(String userName) {
        throw new RuntimeException("requested user not found : " + userName);
    }
}
