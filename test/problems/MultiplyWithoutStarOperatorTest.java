package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyWithoutStarOperatorTest {

    MultiplyWithoutStarOperator subject
            = new MultiplyWithoutStarOperator();
    @Test
    public void multiply() {
        assertEquals(0, subject.multiply(1, 0));
        assertEquals(0, subject.multiply(0, 10));
        assertEquals(10, subject.multiply(1, 10));

        assertEquals(66, subject.multiply(11, 6));
        assertEquals(100, subject.multiply(10, 10));
        assertEquals(6, subject.multiply(2, 3));
    }
}