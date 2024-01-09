package problems;

import java.util.ArrayList;

/**
 * Problem is that given expenses in mm-yyyy format, for different ranges,
 * figure out the minimum salary of the individual to cover those expenses.
 * eg
 * A = ['01-2001', '04-2001']
 * B = ['02-2001', '04-2001']
 * C = [100, 200]
 * This means the person spent 100 rs in JAN-FEB, and 200 rs in APRIL.
 * Answer is 100 here.
 * Assumption :
 *  1. User can carry over the balance from previous month.
 *  2. Minimum Wage is deposited to account in each month.
 */

public class MinimumWageToCoverExpenseII {

    public static class Interval {
        int startMonth;
        int endMonth;
        int expense;

        public Interval(String startTime, String endTime, int expense) {
            this.startMonth = parseTime(startTime);
            this.endMonth = parseTime(endTime);
            this.expense = expense;
        }

        int parseTime(String time) {
            String [] dateTimeArray = time.split("-");
            return Integer.parseInt(dateTimeArray[1] + dateTimeArray[0]);
        }
    }

    static int calculateMonthDifference(int start, int end) {
        int startYear = start / 100;
        int startMonth = start % 100;

        int endYear = end / 100;
        int endMonth = end % 100;

        int totalMonthsStart = startYear * 12 + startMonth;
        int totalMonthsEnd = endYear * 12 + endMonth;

        return totalMonthsEnd - totalMonthsStart + 1; // both months are inclusive
    }

    int computeMinimumWage(String []startDates, String []endDates, int [] expenses) {
        ArrayList<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i < startDates.length; ++i) {
            String startTime = startDates[i], endTime = endDates[i];
            int expense = expenses[i];
            intervalList.add(new Interval(startTime, endTime, expense));
        }

        intervalList.sort((o1, o2) -> o1.startMonth - o2.startMonth);

        return computeMinimumWage(intervalList);
    }

    int computeMinimumWage(ArrayList<Interval> expenseLedger) {

        float minMonthlyWage = 0;
        float previousExpenses = 0;
        int firstMonth = expenseLedger.get(0).startMonth;

        for(Interval interval : expenseLedger) {
            float additionalExpense = calculateMonthDifference(interval.startMonth, interval.endMonth) * interval.expense;
            float availableAccountBalance =
                    calculateMonthDifference(firstMonth, interval.endMonth) * minMonthlyWage - previousExpenses;
            float finalAccountBalance = availableAccountBalance - additionalExpense;
            if(finalAccountBalance < 0) {
                minMonthlyWage += Math.abs(finalAccountBalance) / calculateMonthDifference(firstMonth, interval.endMonth);
            }

            previousExpenses += additionalExpense;
        }
        return (int) Math.floor(minMonthlyWage);
    }

}
