package lld.calendar_service;

import java.util.HashMap;
import java.util.Map;

public class EventService {

    private Map<Integer, Event> eventMap = new HashMap<>();

    public int addEvent(Event event) {
        throw new IllegalStateException("Unable to create event :" + event);
    }

    public Event getEvent(int eventID) {
        throw new RuntimeException("Unable to find event with id :" + eventID);
    }
}
