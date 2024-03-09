package problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumCabBookingTimeUberTest {

    MinimumCabBookingTimeUber subject;

    @Before
    public void setUp() throws Exception {
        subject = new MinimumCabBookingTimeUber();
    }

    @Test
    public void findMinCabBookingTime() {

        assertEquals(0,
                subject.findMinCabBookingTime(0, new int[]{1,1}));
        assertEquals(1,
                subject.findMinCabBookingTime(1, new int[]{1}));
        assertEquals(2,
                subject.findMinCabBookingTime(3, new int[]{1,2}));
        assertEquals(10,
                subject.findMinCabBookingTime(10, new int[]{1}));
        assertEquals(7,
                subject.findMinCabBookingTime(10, new int[]{1,3,5,7,8}));
        assertEquals(1,
                subject.findMinCabBookingTime(6, new int[]{1,1,1,1,1,1}));
    }

    @Test
    public void findMinCabBookingTimeV2() {

        assertEquals(0,
                subject.findMinCabBookingTimeV2(0, new int[]{1,1}));
        assertEquals(1,
                subject.findMinCabBookingTimeV2(1, new int[]{1}));
        assertEquals(2,
                subject.findMinCabBookingTimeV2(3, new int[]{1,2}));
        assertEquals(10,
                subject.findMinCabBookingTimeV2(10, new int[]{1}));
        assertEquals(7,
                subject.findMinCabBookingTimeV2(10, new int[]{1,3,5,7,8}));
        assertEquals(1,
                subject.findMinCabBookingTimeV2(6, new int[]{1,1,1,1,1,1}));
    }

}