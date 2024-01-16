package lld.resource_manager;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class SystemTest {
    System system = new System();

    @Test
    public void allocate() {
        system.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        system.addResource(new Config(4, 2, Config.Performance.MEDIUM), 100);
        system.addResource(new Config(2, 2, Config.Performance.LOW), 10);
        Task task1 = Task.createTask("task1", new Config(4, 2, Config.Performance.MEDIUM));
        Task task2 = Task.createTask("task2", new Config(2, 2, Config.Performance.LOW));
        Task task3 = Task.createTask("task3", new Config(8, 2, Config.Performance.HIGH));
        assertTrue(system.allocate(task1));
        assertTrue(system.allocate(task2));
        assertTrue(system.allocate(task3));
    }

    @Test
    public void addResource() {
        int resourceId1 = system.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        int resourceId2 = system.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        int resourceId3 = system.addResource(new Config(8, 2, Config.Performance.HIGH),100);
        assertEquals(1, resourceId1);
        assertEquals(2, resourceId2);
        assertEquals(3, resourceId3);
        List<Resource> resources = system.listResources();
        assertEquals(3, resources.size());
    }

    @Test
    public void removeResource() {
    }
}