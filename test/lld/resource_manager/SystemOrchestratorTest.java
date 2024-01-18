package lld.resource_manager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class SystemOrchestratorTest {
    SystemOrchestrator systemOrchestrator;

    @Before
    public void before() {
        systemOrchestrator = new SystemOrchestrator();
    }

    @Test
    public void allocate() throws InterruptedException{
        // Create Resources
        systemOrchestrator.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        systemOrchestrator.addResource(new Config(4, 2, Config.Performance.MEDIUM), 50);
        systemOrchestrator.addResource(new Config(2, 2, Config.Performance.LOW), 30);
        // Create Tasks
        Task task1 = Task.createTask("task1", new Config(4, 2, Config.Performance.MEDIUM));
        Task task2 = Task.createTask("task2", new Config(2, 2, Config.Performance.LOW));
        Task task3 = Task.createTask("task3", new Config(8, 2, Config.Performance.HIGH));
        // Create threads
        Thread thread1 = new Thread(() -> assertTrue(systemOrchestrator.allocate(task1)));
        Thread thread2 = new Thread(() -> assertTrue(systemOrchestrator.allocate(task2)));
        Thread thread3 = new Thread(() -> assertTrue(systemOrchestrator.allocate(task3)));

        // act & assert
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        assertFalse(systemOrchestrator.hasPendingTasks());
    }

    @Test
    public void addResource() {
        int resourceId1 = systemOrchestrator.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        int resourceId2 = systemOrchestrator.addResource(new Config(8, 2, Config.Performance.HIGH), 100);
        int resourceId3 = systemOrchestrator.addResource(new Config(8, 2, Config.Performance.HIGH),100);
        assertEquals(1, resourceId1);
        assertEquals(2, resourceId2);
        assertEquals(3, resourceId3);
        List<Resource> resources = systemOrchestrator.listResources();
        assertEquals(3, resources.size());
    }

    @Test
    public void removeResource() {
    }

}