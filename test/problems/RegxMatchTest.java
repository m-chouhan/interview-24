package problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegxMatchTest {

    RegxMatch subject;
    @Before
    public void setUp() throws Exception {
        subject = new RegxMatch();
    }

    @Test
    public void isMatch() {
        assertTrue(subject.isMatch("a", "a*"));
        assertTrue(subject.isMatch("", "a*"));
        assertTrue(subject.isMatch("bc", "a*b*c"));
        assertFalse(subject.isMatch("bc", "a*b*"));
        assertFalse(subject.isMatch("", "a"));
    }
}