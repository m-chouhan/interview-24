package lld.calendar_service;

import java.time.LocalDateTime;

public class Utils {

    static int clipToNextQuarter(LocalDateTime localDateTime) {
        return localDateTime.getHour() * 4 + (localDateTime.getMinute() + 14) / 15;
    }

    static int clipToPrevQuarter(LocalDateTime localDateTime) {
        return localDateTime.getHour() * 4 + localDateTime.getMinute() / 15;
    }

    static LocalDateTime convertToTimestamp(int quarter) {
        int hours = quarter / 4;
        int minutes = (quarter % 4) * 15;
        return LocalDateTime.now().withHour(hours).withMinute(minutes).withSecond(0);
    }
}
