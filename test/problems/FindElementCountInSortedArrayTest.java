package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindElementCountInSortedArrayTest {

    FindElementCountInSortedArray subject = new FindElementCountInSortedArray();
    @Test
    public void findCount() {
        assertEquals(
                1,
                subject.findCount(new int[]{1, 3, 3, 5, 6, 7}, 1)
        );
        assertEquals(
                2,
                subject.findCount(new int[]{1, 3, 3, 5, 6, 7}, 3)
        );
        assertEquals(
                1,
                subject.findCount(new int[]{1, 3, 3, 5, 6, 7}, 5)
        );
        assertEquals(
                3,
                subject.findCount(new int[]{1, 3, 3, 5, 6, 6, 6}, 6)
        );
        assertEquals(
                0,
                subject.findCount(new int[]{1, 3, 3, 5, 6, 6, 6}, 2)
        );
        assertEquals(
                0,
                subject.findCount(new int[]{}, 2)
        );

    }
}