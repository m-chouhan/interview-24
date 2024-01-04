package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TrieStackTest {

    TrieStack subject;
    @Before
    public void setUp() {
        subject = new TrieStack();
        List<String> input = Arrays.asList("my", "name", "is", "mahendra");
        for (String word : input) {
            subject.addWord(word);
        }
    }

    @Test
    public void peekAhead() {
        assertTrue(subject.peekAhead('m'));
        assertTrue(subject.peekAhead('i'));
        assertTrue(subject.peekAhead('n'));
        assertFalse(subject.peekAhead('a'));
        assertFalse(subject.peekAhead('b'));

        subject.push('m');

        assertTrue(subject.peekAhead('y'));
        assertTrue(subject.peekAhead('a'));
        assertFalse(subject.peekAhead('n'));
    }

    @Test
    public void checkRoot() {
        assertFalse(subject.peekRoot('a'));
        assertTrue(subject.peekRoot('m'));
        assertTrue(subject.peekRoot('i'));
        assertTrue(subject.peekRoot('n'));
    }

    @Test
    public void push() {
        subject.push('m');
        subject.push('y');
        assertThrows(IllegalStateException.class, () -> {
           subject.push('x');
        });
    }
    @Test
    public void pop() {
        subject.push('m');
        subject.push('y');
        assertEquals('y', subject.pop());
        assertEquals('m', subject.pop());
        assertEquals('.', subject.pop());
    }
}