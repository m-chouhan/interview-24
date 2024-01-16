package lld.resource_manager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class System {
    ResourceManager resourceManager;
    Deque<Task> taskDeque;

    public System() {
        resourceManager = new ResourceManager();
        taskDeque = new ArrayDeque<>();
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
            taskDeque.add(task);
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
}
