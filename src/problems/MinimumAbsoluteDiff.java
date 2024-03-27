package problems;

import java.util.*;

public class MinimumAbsoluteDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int [] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);
        final long MOD = 1000000007L;
        long sum = 0;
        for(int i = 0; i < nums1.length; ++i) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }

        long minSum = sum;
        for(int i = 0; i < nums2.length; ++i) {
            int index1 = Math.max(findIndex(sortedNums1, nums2[i]), 0); // return smaller or equal num or -1.
            int index2 = Math.min(index1 + 1, sortedNums1.length - 1);

            long previousValue = Math.abs(nums1[i] - nums2[i]);
            long currentValue1 = Math.abs(sortedNums1[index1] - nums2[i]);
            long currentValue2 = Math.abs(sortedNums1[index2] - nums2[i]);
            long bestValue = Math.min(previousValue,
                    Math.min(currentValue1, currentValue2));
            long newSum = (sum - previousValue + bestValue) % MOD;
            minSum = Math.min(minSum, newSum);
        }

        return (int) minSum;
    }

    // find lower or equal value
    int findIndex(int [] array, int num) {
        int start = 0, end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start + 1) / 2;
            if(array[mid] == num) return mid;
            if(array[mid] < num) start = mid;
            else end = mid - 1;
        }

        return array[start] <= num ? start : -1;
    }
}
