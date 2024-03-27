package datastructures.randomizedcollections;

import java.util.*;
import java.util.HashMap;


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedCollectionLiner extends RandomizedCollection {

    HashMap<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int totalCount = 0;

    public RandomizedCollectionLiner() {}

    public boolean insert(int val) {
        int valueCount = map.getOrDefault(val, 0);
        map.put(val, valueCount + 1);
        totalCount++;
        return valueCount == 0;
    }

    public boolean remove(int val) {
        int valueCount = map.getOrDefault(val, 0);
        if(valueCount > 0) {
            map.put(val, valueCount - 1);
            totalCount--;
        }
        else map.remove(val);

        return valueCount > 0;
    }

    public int getRandom() {
        int returnIndex = random.nextInt(totalCount) + 1;
        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            int key = entrySet.getKey();
            int value = entrySet.getValue();
            returnIndex -= value;
            if(returnIndex <= 0) return key;
        }
        return -1;
    }
}