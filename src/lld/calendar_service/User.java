package lld.calendar_service;
import java.util.*;

public class User {
    private String name;
    private List<Integer> eventIds;

    public User(String name) {
        this.name = name;
        this.eventIds = new ArrayList<>();
    }

    public void addEventId(int eventId) {
        eventIds.add(eventId);
    }

    public List<Integer> getEventIds() {
        return eventIds;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}