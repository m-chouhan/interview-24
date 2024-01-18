package lld.resource_manager;

import java.util.List;

public class CheapestFirstStrategy implements AllocationStrategy{
    @Override
    public Resource allocate(List<Resource> resourceList, Config minConfig) {
        resourceList.sort((r1, r2) -> (int) (r1.getPrice() - r2.getPrice()));
        for(Resource resource : resourceList) {
            if(resource.isFree() && resource.config.isLargerOrEqual(minConfig))
                return resource;
        }
        return null;

    }
}
