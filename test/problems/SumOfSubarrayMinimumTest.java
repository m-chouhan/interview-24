package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfSubarrayMinimumTest {

    SumOfSubarrayMinimum subject = new SumOfSubarrayMinimum();

    @Test
    public void sumSubarrayMins() {
        assertEquals(17, subject.sumSubarrayMins(new int[]{3,1,2,4}));
        assertEquals(0, subject.sumSubarrayMins(new int[]{0}));
        assertEquals(1, subject.sumSubarrayMins(new int[]{0, 1}));
        assertEquals(16, subject.sumSubarrayMins(new int[]{10, 1, 2}));
    }
}