package problems;

import datastructures.TrieStack;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WordBreakIITest {

    WordBreakII subject;
    @Before
    public void setup() {
        subject = new WordBreakII();
    }
    @Test
    public void wordBreak1() {
        String input = "helloworld";
        List<String> dictionary = Arrays.asList("hello", "world");
        List<String> expectedOutput = Arrays.asList("hello world");
        List<String> output = subject.wordBreak(input, dictionary);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void wordBreak2() {
        String input = "catsanddog";
        List<String> dictionary = Arrays.asList("cat","cats","and","sand","dog");
        List<String> expectedOutput = Arrays.asList("cats and dog","cat sand dog");
        List<String> output = subject.wordBreak(input, dictionary);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void wordBreak3() {
        String input = "pineapplepenapple";
        List<String> dictionary = Arrays.asList("apple","pen","applepen","pine","pineapple");
        List<String> expectedOutput = Arrays.asList("pine apple pen apple","pineapple pen apple","pine applepen apple");
        List<String> output = subject.wordBreak(input, dictionary);
        assertTrue(expectedOutput.containsAll(output));
        assertTrue(output.containsAll(expectedOutput));
    }

    @Test
    public void wordBreak4() {
        String input = "bb";
        List<String> dictionary = Arrays.asList("a","b","bbb","bbbb");
        List<String> expectedOutput = Arrays.asList("b b");
        List<String> output = subject.wordBreak(input, dictionary);
        assertTrue(expectedOutput.containsAll(output));
        assertTrue(output.containsAll(expectedOutput));
    }
}