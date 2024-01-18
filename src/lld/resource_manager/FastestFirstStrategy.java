package lld.resource_manager;

import java.util.Comparator;
import java.util.List;

/**
 * Speed is determined by #no of cpu's
 * */
public class FastestFirstStrategy implements AllocationStrategy {
    @Override
    public Resource allocate(List<Resource> resourceList, Config minConfig) {
        return resourceList.stream()
                .sorted(Comparator.comparingInt(Resource::getCpu))
                .filter(resource -> resource.isFree() && resource.config.isLargerOrEqual(minConfig))
                .findFirst().orElse(null);
    }
}
