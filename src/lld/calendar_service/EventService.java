package lld.calendar_service;

import java.util.*;

public class EventService {

    private List<Event> eventList = new ArrayList<>();

    public int addEvent(Event event) {
        int eventId = getUniqueId(event);
        event.setId(eventId);
        eventList.add(event);
        return eventId;
    }

    private int getUniqueId(Event event) {
        return eventList.size() + 1;
    }

    public Event getEvent(int eventID) {
        for(Event event : eventList) {
            if(event.getId() == eventID) return event;
        }

        throw new RuntimeException("Unable to find event with id :" + eventID);
    }
}
