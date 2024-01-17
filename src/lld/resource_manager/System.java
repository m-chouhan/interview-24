package lld.resource_manager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/***
 * Class to orchestrate between task management and resource management.
 */
public class System {
    ResourceManager resourceManager;
    TaskManager taskManager;

    public System() {
        taskManager = new TaskManager();
        resourceManager = new ResourceManager(taskManager);
    }

    boolean allocate(Task task) {
        Resource resource = resourceManager.getResource(task.minConfig);
        if(resource != null) {
            try {
                resource.execute(task);
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to execute " + task);
            }
        }
        else {
            taskManager.addTask(task);
            return false;
        }
    }

    int addResource(Config config, float price) {
        return resourceManager.addResource(config, price);
    }

    boolean removeResource(int Id) {
        return false;
    }

    public List<Resource> listResources() {
        return resourceManager.listResources();
    }

    public boolean hasPendingTasks() {
        return taskManager.hasPendingTasks() || resourceManager.hasEngagedResources();
    }
}
