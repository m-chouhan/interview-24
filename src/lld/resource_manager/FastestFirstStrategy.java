package lld.resource_manager;

import java.util.List;

/**
 * Speed is determined by #no of cpu's
 * */
public class FastestFirstStrategy implements AllocationStrategy {
    @Override
    public Resource allocate(List<Resource> resourceList, Config minConfig) {
        resourceList.sort((r1, r2) -> r1.getCpu() - r2.getCpu());
        for(Resource resource : resourceList) {
            if(resource.isFree() && resource.config.isLargerOrEqual(minConfig))
                return resource;
        }
        return null;
    }
}
