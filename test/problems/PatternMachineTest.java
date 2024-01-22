package problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PatternMachineTest {

    PatternMachine subject = new PatternMachine();
    @Test
    public void patternMatch() {
        assertEquals(0, subject.patternMatch("", "mahendra"));
        assertEquals(3, subject.patternMatch("0", "mahendra"));
        assertEquals(3, subject.patternMatch("0", "amazon"));
        assertEquals(1, subject.patternMatch("010", "rahul"));
    }
}