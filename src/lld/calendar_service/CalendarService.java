package lld.calendar_service;
import java.util.*;

class CalendarService {
    private final EventService eventService;
    private final UserService userService;

    public CalendarService(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    public int addEvent(Event event) {
        return eventService.addEvent(event);
    }

    public List<Event> getEvents(String userName) {
        return userService.getUser(userName).getEvents();
    }

    public Event getEventDetails(int eventID) {
        return eventService.getEvent(eventID);
    }
}
