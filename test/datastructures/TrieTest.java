package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    Trie subject = new Trie();
    @Test
    public void addWord() {
        subject.addWord("Mahendra");
        subject.addWord("Chouhan");

        // test for falsebility
        assertFalse(subject.contains("M"));
        assertFalse(subject.contains(""));
        assertFalse(subject.contains("hendra"));
        // test for truthness
        assertTrue(subject.contains("Mahendra"));
        assertTrue(subject.contains("Chouhan"));

        // nullness check
        subject.addWord("");
        assertTrue(subject.contains(""));

        // should be case in-sensetive
        assertTrue(subject.contains("mahendra"));
    }
}