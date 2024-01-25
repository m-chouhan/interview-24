package lld.calendar_service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lld.calendar_service.Utils.*;

/**
 * Responsible for managing complex logic of event scheduling
 * */
public class EventScheduler {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public List<Event> getConflictingEvents(List<Event> events, TimeSlot timeSlot) {
        List<Event> filteredEvents = events.stream()
                .filter(timeSlot::contains)
                .sorted(Comparator.comparing(Event::getStart))
                .toList();

        List<Event> overlappingEvents = new ArrayList<>();
        for (int i = 0; i < filteredEvents.size(); i++) {
            for (int j = i + 1; j < filteredEvents.size(); j++) {
                if (filteredEvents.get(i).overlapsWith(filteredEvents.get(j))) {
                    overlappingEvents.add(filteredEvents.get(i));
                    overlappingEvents.add(filteredEvents.get(j));
                }
            }
        }

        return overlappingEvents;
    }

    // All computations will happen in quarterly slots, for simplicity
    // i.e, 00:00 - 00:15 - 00:30 and so on.
    public List<TimeSlot> getRecommendSlot(TimeSlot timeSlot, String slotSize, List<Event> allEvents) {
        List<Event> sortedList = allEvents.stream()
                .filter(timeSlot::contains)
                .sorted(Comparator.comparing(Event::getStart))
                .toList();

        LocalDateTime time = LocalDateTime.parse(slotSize, formatter);
        int minimumSlotSizeInQuarters = time.getHour() * 4 + (time.getMinute() + 14) / 15;
        int lastAvailableSlot = clipToNextQuarter(timeSlot.startTime);
        List<TimeSlot> recommendedSlots = new ArrayList<>();

        for(Event event : sortedList) {
            int currentAvailableSlot = clipToPrevQuarter(event.getStart());
            int currentAvailableSlotSize = currentAvailableSlot - lastAvailableSlot;
            if (currentAvailableSlotSize >= minimumSlotSizeInQuarters) {
                recommendedSlots.add(
                        new TimeSlot(convertToTimestamp(lastAvailableSlot),
                        convertToTimestamp(currentAvailableSlot)));
            }
            lastAvailableSlot = clipToNextQuarter(event.getEnd());
        }

        return recommendedSlots;
    }
}
