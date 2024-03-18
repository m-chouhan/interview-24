package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxSumFromHeadOrTailMicrosoftTest {

    FindMaxSumFromHeadOrTailMicrosoft subject = new FindMaxSumFromHeadOrTailMicrosoft();
    @Test
    public void findMaxSum() {
        int [] array1 = new int[]{1,13,5,6,7,8,9};
        assertEquals(9, subject.findMaxSum(array1, 1));
        assertEquals(17, subject.findMaxSum(array1, 2));
        assertEquals(24, subject.findMaxSum(array1, 3));
    }
}