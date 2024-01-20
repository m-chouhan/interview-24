package lld.calendar_service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Event {
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<User> participants;
    private int id;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Event(String title, String startTime, String endTime, User... participants) {
        this.title = title;
        this.start = LocalDateTime.parse(startTime, formatter);
        this.end = LocalDateTime.parse(endTime, formatter);
        this.participants = new ArrayList<>();
        this.participants.addAll(Arrays.asList(participants));
    }

    public String getTitle() {
        return this.title;
    }

    public List<User> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", participants=" + participants.stream().map(User::toString).collect(Collectors.joining(", ")) +
                '}';
    }

    public void setId(int eventId) {
        this.id = eventId;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    // first user in the list is the organizer
    User getEventOrganizer() {
        return participants.getFirst();
    }

    public boolean overlapsWith(Event event) {
        boolean case1 = start.isBefore(event.start) && end.isAfter(event.start);
        boolean case2 = start.isBefore(event.end) && end.isEqual(event.start);
        return case1 || case2;
    }

}

