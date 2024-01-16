package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumEditDistanceTest {

    MinimumEditDistance subject = new MinimumEditDistance();

    @Test
    public void minDistance() {
        assertEquals(8, subject.minDistance("", "Mahendra"));
        assertEquals(0, subject.minDistance("", ""));
        assertEquals(3, subject.minDistance("ABC", "XYZ"));
        assertEquals(3, subject.minDistance("horse", "ros"));
    }

    @Test
    public void minDistanceIterative() {
        assertEquals(8, subject.minDistanceIterative("", "Mahendra"));
        assertEquals(0, subject.minDistanceIterative("", ""));
        assertEquals(3, subject.minDistanceIterative("ABC", "XYZ"));
        assertEquals(3, subject.minDistanceIterative("horse", "ros"));
    }

}