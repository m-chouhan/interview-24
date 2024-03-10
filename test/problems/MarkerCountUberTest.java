package problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarkerCountUberTest {

    MarkerCountUber subject;
    @Before
    public void setup() {
        subject = new MarkerCountUber();
    }

    @Test
    public void countMarkers() {
        int[][] coordinates1 = {{4, 7}, {-1, 5}, {3, 6}};
        assertEquals(9, subject.countMarkers(coordinates1));
        int[][] coordinates2 = {{4, 7}, {3, 4}};
        assertEquals(5, subject.countMarkers(coordinates2));
        int[][] coordinates3 = {{-1, 5}};
        assertEquals(7, subject.countMarkers(coordinates3));
        int[][] coordinates4 = {{1, 100}, {0, Integer.MAX_VALUE / 2}};
        assertEquals(Integer.MAX_VALUE/2 + 1, subject.countMarkers(coordinates4));
    }
}