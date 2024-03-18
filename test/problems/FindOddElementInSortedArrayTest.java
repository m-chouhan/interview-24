package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindOddElementInSortedArrayTest {

    FindOddElementInSortedArray subject = new FindOddElementInSortedArray();

    @Test
    public void findOdd() {
        assertEquals(-1, subject.findOdd(new int[]{1,1,2,2}));
        assertEquals(3, subject.findOdd(new int[]{1,1,2,2,3}));
        assertEquals(2, subject.findOdd(new int[]{1,1,2,3,3}));
        assertEquals(3, subject.findOdd(new int[]{1,1,2,2,3,3,3,4,4}));
    }
}