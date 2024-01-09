package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWageToCoverIntervalExpenseTest {

    MinimumWageToCoverIntervalExpense subject = new MinimumWageToCoverIntervalExpense();

    @Test
    public void countMinimumWage() {
        String [] startDates = {"01-2001"};
        String [] endDates = {"01-2001"};
        int [] expenses = {100};
        int actual = subject.countMinimumWage(startDates, endDates, expenses);
        assertEquals(100, actual);

        String [] startDates1 = {"01-2001", "10-1992", "11-1992", "01-2001"};
        String [] endDates1 = {"01-2001", "12-1992", "11-1992", "12-2001"};
        int [] expenses1 = {100, 200, 50, 300};
        int actual1 = subject.countMinimumWage(startDates1, endDates1, expenses1);
        assertEquals(400, actual1);
    }
}