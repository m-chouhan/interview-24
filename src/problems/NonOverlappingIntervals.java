package problems;

import java.util.*;

/**
 * DP
 * Variant of this was recently asked at microsoft.
 * Leetcode : https://leetcode.com/problems/non-overlapping-intervals
 */
public class NonOverlappingIntervals {
    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "("+ start + "," + end + ")";
        }
    }

    int [] cache;

    public int eraseOverlapIntervals(int[][] intervals) {
        // initialize right values
        ArrayList<Interval> sortedList = new ArrayList<>();
        for(int []interval : intervals) {
            sortedList.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(sortedList, (o1, o2) -> o1.start - o2.start);

        cache = new int[sortedList.size() + 1];
        Arrays.fill(cache, -1);

        return computeMin(sortedList, sortedList.size());
    }

    int computeMin(ArrayList<Interval> list, int currentCount) {
        if(currentCount <= 1) { return 0; }
        if(cache[currentCount] != -1) return cache[currentCount];

        Interval currentInterval = list.get(currentCount - 1);
        int nonOverlappingCount = findNonOverlapping(list, currentCount); // number, not index
        int bestIncludingCurrentInterval =
                computeMin(list, nonOverlappingCount) + currentCount - nonOverlappingCount - 1;
        int bestExcludingCurrentInterval = computeMin(list, currentCount - 1) + 1;
        cache[currentCount] = Math.min(bestIncludingCurrentInterval, bestExcludingCurrentInterval);
        return cache[currentCount];
    }

    int findNonOverlapping(ArrayList<Interval> list, int targetCount) {
        Interval targetInterval = list.get(targetCount - 1);
        int currentCount = targetCount - 1;
        while(currentCount > 0) {
            if(list.get(currentCount - 1).end <= targetInterval.start) return currentCount;
            currentCount--;
        }
        return 0;
    }
}
