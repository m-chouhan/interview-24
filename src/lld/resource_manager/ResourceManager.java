package lld.resource_manager;

import java.util.*;

public class ResourceManager {
    private final List<Resource> resourceList = new ArrayList<>();
    private final TaskManager taskManager;
    private final AllocationStrategy allocationStrategy;

    ResourceManager(TaskManager taskManager, AllocationStrategy allocationStrategy) {
        this.taskManager = taskManager;
        this.allocationStrategy = allocationStrategy;
    }

    Resource getResource(Config minConfig) {
        return allocationStrategy.allocate(resourceList, minConfig);
    }

    public void notifyCompletion(Resource resource, Task task) {
        // log task completion, ask for additional work.
        java.lang.System.out.printf("Completed %s by %s%n", task, resource);
        final Task nextTask;
        synchronized (taskManager) {
            if(!taskManager.hasPendingTasks()) return;
            if(!resource.config.isLargerOrEqual(taskManager.peek().minConfig)) return;
            nextTask = taskManager.reteriveTask();
        }
        try {
            resource.execute(nextTask);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Consider a different exception or error handling strategy
        }
    }

    public int addResource(Config config, float price) {
        Resource resource = new Resource(resourceList.size() + 1, config, price, this);
        resourceList.add(resource);
        return resource.id;
    }

    public List<Resource> listResources() {
        return this.resourceList;
    }

    public boolean hasEngagedResources() {
        return resourceList.stream().anyMatch(resource -> !resource.isFree());
    }
}
