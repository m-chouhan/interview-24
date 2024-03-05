package lld.atlassian_file_manager;

import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    Set<File> allFiles = new HashSet<>();
    Set<Collection> allCollections = new HashSet<>();

    int totalFileSize() {
        int sum = 0;
        for(File file : allFiles)
            sum += file.size;
        return sum;
    }

    List<Collection> getTopNCollections(int N) {

        List<Collection> sortedCollection = allCollections.stream()
        .sorted((c1, c2) -> {
            return Integer.compare(c2.size(), c1.size());
        }).collect(Collectors.toList());

        List<Collection> collectionList = new ArrayList<>();
        for(Collection c : sortedCollection) {
            if(collectionList.size() < N) collectionList.add(c);
            else break;
        }
        return collectionList;
    }

    boolean addFiles(File file, String collectionName) {
        if(collectionName.isEmpty()) {
            allFiles.add(file);
            return true;
        }

        Optional<Collection> someCollection = allCollections.stream()
                .filter(collection -> collection.collectionName.equals(collectionName))
                .findFirst();
        if(someCollection.isEmpty()) {
            Collection c = new Collection(collectionName);
            allCollections.add(c);
            c.addFile(file);
            allFiles.add(file);
            return c.addFile(file) && allFiles.add(file);
        } else {
            Collection c = someCollection.get();
            return c.addFile(file) && allFiles.add(file);
        }
    }
}
