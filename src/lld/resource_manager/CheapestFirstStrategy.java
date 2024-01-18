package lld.resource_manager;

import java.util.Comparator;
import java.util.List;

public class CheapestFirstStrategy implements AllocationStrategy{
    @Override
    public Resource allocate(List<Resource> resourceList, Config minConfig) {
        return resourceList.stream()
                .sorted(Comparator.comparingDouble(Resource::getPrice))
                .filter(resource -> resource.isFree() && resource.config.isLargerOrEqual(minConfig))
                .findFirst()
                .orElse(null);
    }
}
