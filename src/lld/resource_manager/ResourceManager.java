package lld.resource_manager;

import java.util.*;

public class ResourceManager {
    List<Resource> resourceList = new ArrayList<>();
    Resource getResource(Config minConfig) {
        for(Resource resource : resourceList) {
            if(resource.isFree() && resource.config.isLargerOrEqual(minConfig))
                return resource;
        }
        return null;
    }

    public void notifyCompletion(Resource resource, Task task) {
        // log task completion
    }

    public int addResource(Config config, float price) {
        Resource resource = new Resource(resourceList.size() + 1, config, price, this);
        resourceList.add(resource);
        return resource.id;
    }

    public List<Resource> listResources() {
        return this.resourceList;
    }
}
