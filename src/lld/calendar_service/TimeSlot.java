package lld.calendar_service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSlot {
    LocalDateTime startTime;
    LocalDateTime endTime;
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public TimeSlot(String startTime, String endTime) {
        this.startTime = LocalDateTime.parse(startTime, formatter);
        this.endTime = LocalDateTime.parse(endTime, formatter);
    }
    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public TimeSlot(String date) {
        this.startTime = LocalDateTime.parse(date + " 00:01", formatter);
        this.endTime = LocalDateTime.parse(date + " 23:59", formatter);
    }
    public boolean contains(LocalDateTime time) {
        if(time.isEqual(startTime) || time.isEqual(endTime)) return true;
        return startTime.isBefore(time) && endTime.isAfter(time);
    }
    public boolean contains(Event event) {
        return contains(event.getStart()) || contains(event.getEnd());
    }
}
