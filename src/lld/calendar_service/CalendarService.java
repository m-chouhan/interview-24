package lld.calendar_service;
import java.util.*;
import java.util.stream.Collectors;

class CalendarService {
    private final EventService eventService;
    private final UserService userService;
    private final EventScheduler scheduler;

    public CalendarService(EventService eventService, UserService userService, EventScheduler scheduler) {
        this.eventService = eventService;
        this.userService = userService;
        this.scheduler = scheduler;
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

    public List<TimeSlot> getRecommendedSlots(String date, String slotSize, User... participants) {
        List<Event> allUserEvents = Arrays.stream(participants)
                .flatMap(user -> user.getEventIds().stream())
                .distinct()
                .map(this::getEventDetails)
                .toList();
        return scheduler.getRecommendSlot(new TimeSlot(date), slotSize, allUserEvents);
    }

    public List<Event> getConflictingEvents(User user1, String startTime, String endTime) {
        return scheduler.getConflictingEvents(getEvents(user1.getName()), new TimeSlot(startTime, endTime));
    }
}
