package datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class SortedBTreeTest {

    SortedBTree<Integer> subject;
    @Before
    public void before() {
        subject = new SortedBTree<>();
    }

    @Test
    public void add() {
        assertTrue(subject.add(1));
        assertFalse(subject.add(1));
        assertTrue(subject.add(10));
        assertTrue(subject.add(12));
    }

    @Test
    public void remove() {
        subject.add(10);
        subject.add(5);
        subject.add(15);
        subject.add(12);

        assertTrue(subject.remove(10));
        assertFalse(subject.remove(10));
        assertTrue(subject.remove(15));
        assertFalse(subject.remove(100));
        assertTrue(subject.remove(12));
        assertTrue(subject.remove(5));
    }

    @Test
    public void contains() {
        subject.add(10);
        subject.add(5);
        subject.add(15);
        subject.add(12);

        assertTrue(subject.contains(10));
        assertTrue(subject.contains(5));
        assertTrue(subject.contains(15));
        assertTrue(subject.contains(12));
        assertFalse(subject.contains(1));
    }

    @Test
    public void size() {
        assertEquals(0, subject.size());
        subject.add(1);
        assertEquals(1, subject.size());
        subject.add(2);
        assertEquals(2, subject.size());
        subject.add(3);
        assertEquals(3, subject.size());
        subject.remove(1);
        assertEquals(2, subject.size());
        subject.remove(2);
        assertEquals(1, subject.size());
        subject.remove(2);
        assertEquals(1, subject.size());
        subject.remove(3);
        assertEquals(0, subject.size());
        subject.remove(3);
        assertEquals(0, subject.size());
    }

    @Test
    public void toArray() {
        subject.add(10);
        subject.add(5);
        subject.add(15);
        subject.add(12);
        assertEquals(Arrays.asList(5, 10, 12,15), subject.toArray());
    }
}