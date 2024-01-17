package lld.resource_manager;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskManager {
    private Deque<Task> pendingTasks;
    TaskManager() {
        pendingTasks = new ArrayDeque<>();
    }
    public void addTask(Task task) {
        pendingTasks.add(task);
    }

    boolean hasPendingTasks() {
        return !pendingTasks.isEmpty();
    }

    Task reteriveTask() {
        return pendingTasks.remove();
    }

    Task peek() {
        return pendingTasks.peek();
    }

}
