package problems;

import java.util.*;

/**
 * Problem is that given expenses in mm-yyyy format, for different ranges,
 * figure out the minimum salary of the individual to cover those expenses.
 * eg
 * A = ['01-2001', '04-2001']
 * B = ['02-2001', '04-2001']
 * C = [100, 200]
 * This means the person spent 100 rs in JAN-FEB, and 200 rs in APRIL.
 * Answer is 200 here.
 * Assumption : No carry over of bank balance from previous months.
 */
public class MinimumWageToCoverIntervalExpense {

    public static class Interval {
        int time;
        int expense;
        boolean isStart;

        public Interval(String time, int expense, boolean isStart) {
            this.time = parseTime(time);
            this.expense = expense;
            this.isStart = isStart;
        }

        int parseTime(String time) {
            String [] dateTimeArray = time.split("-");
            return Integer.parseInt(dateTimeArray[1] + dateTimeArray[0]);
        }
    }

    int computeMinimumWage(String []startDates, String []endDates, int [] expenses) {
        ArrayList<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i < startDates.length; ++i) {
            String startTime = startDates[i], endTime = endDates[i];
            int expense = expenses[i];
            intervalList.add(new Interval(startTime, expense, true));
            intervalList.add(new Interval(endTime, expense, false));
        }

        intervalList.sort((o1, o2) -> {
            if(o1.time != o2.time) return o1.time - o2.time;
            return Boolean.compare(!o1.isStart, !o2.isStart);
        });

        return computeMinimumWage(intervalList);
    }

    int computeMinimumWage(ArrayList<Interval> expenseLedger) {
        int currentWage = 0;
        int maxWage = Integer.MIN_VALUE;
        for(Interval interval : expenseLedger) {
            if(interval.isStart) currentWage += interval.expense;
            else currentWage -= interval.expense;
            maxWage = Math.max(currentWage, maxWage);
        }
        return maxWage;
    }
}
