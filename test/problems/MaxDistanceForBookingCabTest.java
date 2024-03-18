package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDistanceForBookingCabTest {

    MaxDistanceForBookingCab maxDistanceForBookingCab = new MaxDistanceForBookingCab(10);

    @Test
    public void next() {
        assertEquals(0, maxDistanceForBookingCab.next());
        assertEquals(9, maxDistanceForBookingCab.next());
        assertEquals(5, maxDistanceForBookingCab.next());
        assertEquals(2, maxDistanceForBookingCab.next());
        assertEquals(7, maxDistanceForBookingCab.next());
    }

    @Test
    public void remove() {
        assertEquals(0, maxDistanceForBookingCab.next());
        assertEquals(9, maxDistanceForBookingCab.next());
        maxDistanceForBookingCab.remove(0);
        assertEquals(0, maxDistanceForBookingCab.next());
        maxDistanceForBookingCab.remove(9);
        assertEquals(9, maxDistanceForBookingCab.next());
        assertEquals(5, maxDistanceForBookingCab.next());
        maxDistanceForBookingCab.remove(0);
        assertEquals(0, maxDistanceForBookingCab.next());
    }
}