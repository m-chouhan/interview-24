package lld.calendar_service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<User> participants;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Event(String title, String startTime, String endTime, User... participants) {
        this.title = title;
        this.start = LocalDateTime.parse(startTime, formatter);
        this.end = LocalDateTime.parse(endTime, formatter);
        this.participants = new ArrayList<>();
        for (User participant : participants) {
            this.participants.add(participant);
            participant.addEvent(this);
        }
    }

    public String getTitle() {
        return this.title;
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
}

