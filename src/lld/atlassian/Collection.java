package lld.atlassian;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Collection {
    Set<File> files = new HashSet<>();
    String collectionName;

    Collection(String collectionName) {
        this.collectionName = collectionName;
    }

    boolean addFile(File file) {
        return files.add(file);
    }

    int size() {
        int sum = 0;
        for(File file : files)
            sum += file.size;
        return sum;
    }
}
