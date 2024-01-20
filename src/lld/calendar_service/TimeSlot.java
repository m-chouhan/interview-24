package lld.calendar_service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSlot {
    LocalDateTime startTime;
    LocalDateTime endTime;

    public TimeSlot(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.startTime = LocalDateTime.parse(startTime, formatter);
        this.endTime = LocalDateTime.parse(endTime, formatter);
    }

    public boolean contains(LocalDateTime time) {
        if(time.isEqual(startTime) || time.isEqual(endTime)) return true;
        return startTime.isBefore(time) && endTime.isAfter(time);
    }
}
