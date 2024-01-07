package problems;

/***
 * Figure out total number of games a player can play, when start and end time are
 * given in a HH:mm 24 hr format. Also the start / end time of games are fixed, X games per hours or something like that
 * :P.
 * Constraints : start / end time can be in any order, depending on the time of clock.
 * eg start : 10:15, end : 11:11
 * answer : 3 games. (Note : Player cannot finish the last game, which ends at 11:15)
 * Leetcode : https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
 */
public class TotalIntervalsToPlayAGameMicrosoft {

    int parseHours(String time) {
        String hours = time.split(":")[0];
        return Integer.parseInt(hours);
    }

    int parseMin(String time) {
        String mins = time.split(":")[1];
        return Integer.parseInt(mins);
    }

    public int numberOfRounds(String loginTime, String logoutTime) {

        int startTimeHrs = parseHours(loginTime), endTimeHrs = parseHours(logoutTime);
        int startTime = startTimeHrs*60 + parseMin(loginTime), endTime = endTimeHrs*60 + parseMin(logoutTime);

        if(endTime >= startTime && endTime - startTime < 15) { return 0; }

        int adjustStartMinutes = ((startTime + 14) / 15) * 15;
        int adjustedEndMinutes = (endTime/15) * 15;

        int totalMins = adjustedEndMinutes - adjustStartMinutes;
        if(totalMins < 0) {
            totalMins = 24*60 - adjustStartMinutes + adjustedEndMinutes;
        }

        return totalMins / 15;
    }
}
