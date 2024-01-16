package lld.resource_manager;

import java.util.*;

public class ResourceManager {

    List<Resource> resourceList = new ArrayList<>();
    Resource getResource(Config config) { return null; }

    public void notifyCompletion(Resource resource, Task task) {
        // log task completion
    }

    public int addResource(Config config, float price) {
        Resource resource = new Resource(resourceList.size() + 1, config, price);
        resourceList.add(resource);
        return resource.id;
    }

    public List<Resource> listResources() {
        return this.resourceList;
    }
}
