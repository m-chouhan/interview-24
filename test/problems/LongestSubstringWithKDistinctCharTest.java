package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithKDistinctCharTest {

    LongestSubstringWithKDistinctChar
        subject = new LongestSubstringWithKDistinctChar();

    @Test
    public void lengthOfLongestSubstringKDistinct() {
        String actual = subject.lengthOfLongestSubstringKDistinct("bccbababd", 2);
        assertEquals("babab", actual);

        String actual2 = subject.lengthOfLongestSubstringKDistinct("bccbababd", 3);
        assertEquals("bccbabab", actual2);
    }
}