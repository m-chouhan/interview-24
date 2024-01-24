package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericBinaryTreeTest {

    GenericBinaryTree<Integer> subject;
    @Before
    public void before() {
        subject = new GenericBinaryTree<>();
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
    }

    @Test
    public void toArray() {
    }
}