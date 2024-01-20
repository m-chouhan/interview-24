package lld.calendar_service;
import java.util.*;
import java.util.stream.Collectors;

class CalendarService {
    private final EventService eventService;
    private final UserService userService;

    public CalendarService(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    public int addEvent(Event event) {
        int eventId = eventService.addEvent(event);
        List<User> users = event.getParticipants();
        for(User user : users) {
            user.addEventId(eventId);
        }
        return eventId;
    }

    public List<Event> getEvents(String userName) {
        return userService.getUser(userName).getEventIds().stream()
                .map(eventService::getEvent)
                .collect(Collectors.toList());
    }

    public Event getEventDetails(int eventID) {
        return eventService.getEvent(eventID);
    }

    public List<TimeSlot> getRecommendedSlots(String date, String slotSize, User user1, User user2, User user3) {
        throw new RuntimeException("Method not implemented!");
    }

    public List<Event> getConflictingEvents(User user1, String startTime, String endTime) {
        return null;
    }
}