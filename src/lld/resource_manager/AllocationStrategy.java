package lld.resource_manager;

import java.util.*;

public interface AllocationStrategy {
    Resource allocate(List<Resource> resourceList, Config minConfig);
}
