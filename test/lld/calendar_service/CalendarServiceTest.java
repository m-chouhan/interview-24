package lld.calendar_service;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class CalendarServiceTest {

    CalendarService calendarService;
    UserService userService;
    EventService eventService;

    @Before
    public void before() {
        User user1 = new User("Mahendra");
        User user2 = new User("Rahul");
        User user3 = new User("Kokil");

        userService = new UserService();
        userService.addAll(user1, user2, user3);
        eventService = new EventService();

        calendarService = new CalendarService(eventService, userService);
    }

    @Test
    public void addEvent() {
        User user1 = userService.getUser("Mahendra");
        User user2 = userService.getUser("Rahul");

        int eventId1 = calendarService.addEvent(new Event("Study Time", "20-01-2024 11:00", "20-01-2024 12:15", user1));
        assertEquals(1, eventId1);

        int eventId2 = calendarService.addEvent(new Event("Study Time", "20-01-2024 11:00", "20-01-2024 12:15", user2));
        assertEquals(2, eventId2);

//      Overlapping Events are allowed!
//        assertThrows(IllegalStateException.class, () -> {
//            calendarService.addEvent(new Event("Play Time", "20-01-2024 11:15", "20-01-2024 12:00", user2));
//        });
        int eventId3 = calendarService.addEvent(new Event("Play Cricket", "20-01-2024 12:15", "20-01-2024 01:15", user1, user2));
        assertEquals(3, eventId3);
    }

    @Test
    public void getEvents() {
        User user1 = userService.getUser("Mahendra");
        User user2 = userService.getUser("Rahul");

        calendarService.addEvent(new Event("Study Time", "20-01-2024 11:00", "20-01-2024 12:15", user1));
        calendarService.addEvent(new Event("Study Time", "20-01-2024 11:00", "20-01-2024 12:15", user2));
        calendarService.addEvent(new Event("Play Cricket", "20-01-2024 12:15", "20-01-2024 01:15", user1, user2));

        List<Event> events1 = calendarService.getEvents("Mahendra");
        assertEquals(2, events1.size());
        List<Event> events2 = calendarService.getEvents("Rahul");
        assertEquals(2, events2.size());

        Event event1 = calendarService.getEventDetails(1);
        assertEquals("Study Time", event1.getTitle());

        Event event2 = calendarService.getEventDetails(2);
        assertEquals("Study Time", event2.getTitle());

        Event event3 = calendarService.getEventDetails(3);
        assertEquals("Play Cricket", event3.getTitle());
    }

    @Test
    public void getConflictingEvents() {
        
    }

    @Test
    public void getRecommendedSlot() {
    }

}