package datastructures;

class HashMap {

    class Entry {
        int key;
        int value;
        Entry next;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] buckets;
    private static final int INITIAL_CAPACITY = 16; // Initial capacity of the HashMap

    public HashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    // Hash function to calculate index for a key
    private int getBucketIndex(int key) {
        return key % buckets.length;
    }

    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        Entry newEntry = new Entry(key, value);
        Entry current = buckets[bucketIndex];

        // If the bucket is empty, insert the new entry.
        if (current == null) {
            buckets[bucketIndex] = newEntry;
            return;
        }

        // Traverse the chain and look for the key, update if found
        Entry prev = null;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        // Key not found, insert new entry at the end of the chain
        if (prev != null) {
            prev.next = newEntry;
        }
    }

    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
        Entry current = buckets[bucketIndex];

        // Traverse the chain to find the key
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        // Key not found, return -1 or a sentinel value
        return -1;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        Entry current = buckets[bucketIndex];
        Entry prev = null;

        // Traverse the chain to find the key
        while (current != null) {
            if (current.key == key) {
                if (prev != null) {
                    prev.next = current.next; // Remove the current entry by linking its previous entry to its next
                } else {
                    buckets[bucketIndex] = current.next; // Handle the case where the entry to remove is the first in the bucket
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
