package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWageToCoverExpenseIITest {

    MinimumWageToCoverExpenseII subject = new MinimumWageToCoverExpenseII();

    @Test
    public void computeMinimumWage() {
        String [] startDates = {"01-2001"};
        String [] endDates = {"01-2001"};
        int [] expenses = {100};
        int actual = subject.computeMinimumWage(startDates, endDates, expenses);
        assertEquals(100, actual);

        String [] startDates1 = {"01-2001", "05-2001"};
        String [] endDates1 = {"01-2001", "06-2001"};
        int [] expenses1 = {100, 200};
        int actual1 = subject.computeMinimumWage(startDates1, endDates1, expenses1);
        assertEquals(100, actual1);
    }
}