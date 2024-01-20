package lld.calendar_service;

import java.util.*;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public User getUser(String userName) {
        for(User user : userList) {
            if(user.getName().equalsIgnoreCase(userName)) return user;
        }

        throw new RuntimeException("requested user not found : " + userName);
    }

    public void addAll(User ...users) {
        userList.addAll(Arrays.asList(users));
    }
}
