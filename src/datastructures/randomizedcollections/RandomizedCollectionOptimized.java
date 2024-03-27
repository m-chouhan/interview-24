package datastructures.randomizedcollections;
import java.util.*;
import java.util.HashMap;

class RandomizedCollectionOptimized extends RandomizedCollection {

    ArrayList<Integer> numberList = new ArrayList<>();
    HashMap</*value*/Integer, /* indexes */ Set<Integer>>
            hashMap = new HashMap<>();

    Random random = new Random();

    public boolean insert(int val) {
        int insertIndex = numberList.size();
        numberList.add(val);

        Set<Integer> indexSet = hashMap.getOrDefault(val, new HashSet<>());
        indexSet.add(insertIndex);
        hashMap.put(val, indexSet);
        return indexSet.size() < 2;
    }

    public boolean remove(int val) {
        Set<Integer> indexSet = hashMap.getOrDefault(val, null);
        if(indexSet == null || indexSet.isEmpty()) return false;

        int indexToRemove = numberList.size() - 1;
        int lastItemInArray = numberList.get(indexToRemove);
        Set<Integer> indexSetForLastItem = hashMap.get(lastItemInArray);
        int indexToReplace = indexSet.iterator().next();
        if(lastItemInArray == val) {
            indexSet.remove(indexToRemove);
            numberList.remove(indexToRemove);
        } else {
            // update number list
            numberList.set(indexToReplace, lastItemInArray);
            numberList.remove(indexToRemove);
            // update set for last item
            indexSetForLastItem.remove(indexToRemove);
            indexSetForLastItem.add(indexToReplace);
            // update set for current item.
            indexSet.remove(indexToReplace);
        }
        return true;
    }

    public int getRandom() {
        return numberList.get(random.nextInt(numberList.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */