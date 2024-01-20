package lld.calendar_service;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        TimeSlot slot = new TimeSlot(startTime, endTime);
        List<Event> events = getEvents(user1.getName()).stream()
                .filter(event -> slot.contains(event.getStart()) || slot.contains(event.getEnd()))
                .sorted(Comparator.comparing(Event::getStart))
                .toList();

        List<Event> overlappingEvents = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                if (events.get(i).overlapsWith(events.get(j))) {
                    overlappingEvents.add(events.get(i));
                    overlappingEvents.add(events.get(j));
                }
            }
        }

        return overlappingEvents;
    }
}
