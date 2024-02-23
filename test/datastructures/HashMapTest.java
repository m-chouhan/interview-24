package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    HashMap subject;
    @Before
    public void before() {
        subject = new HashMap();
    }
    @Test
    public void put() {
        subject.put(1, 10);
        subject.put(17, 5);

        assertEquals(10, (int) subject.get(1));
        assertEquals(5, (int) subject.get(17));
    }

    @Test
    public void get() {
    }
}