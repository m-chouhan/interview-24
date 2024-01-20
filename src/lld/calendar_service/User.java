package lld.calendar_service;
import java.util.*;

class User {
    private String name;
    private List<Event> events;

    public User(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return name;
    }
}