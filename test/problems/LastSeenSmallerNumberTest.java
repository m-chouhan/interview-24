package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LastSeenSmallerNumberTest {

    LastSeenSmallerNumber subject = new LastSeenSmallerNumber();
    @Test
    public void findSmallerNumbers() {
        int []ans1 = subject.findSmallerNumbers(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4}, ans1);

        int []ans2 = subject.findSmallerNumbers(new int[]{1, 2, 3, 1, 1});
        assertArrayEquals(new int[]{-1, 1, 2, -1, -1}, ans2);

        int []ans3 = subject.findSmallerNumbers(new int[]{0, 10, 0, 10});
        assertArrayEquals(new int[]{-1, 0, -1, 0}, ans3);

        int []ans4 = subject.findSmallerNumbers(new int[]{1, 2, 2, 1});
        assertArrayEquals(new int[]{-1, 1, 1, -1}, ans4);

    }
}