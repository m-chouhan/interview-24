package problems;

/**
 * Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 * */
public class MergeSortedArray {
    public void merge(int[] nums1, int M, int[] nums2, int N) {
        int indexToFill = M + N - 1;
        int i = M - 1, j = N - 1;
        while(indexToFill >= 0) {
            int valueToFill = 0;
            if(i < 0) valueToFill = nums2[j--];
            else if(j < 0) valueToFill = nums1[i--];
            else if(nums1[i] < nums2[j])
                valueToFill = nums2[j--];
            else
                valueToFill = nums1[i--];
            nums1[indexToFill] = valueToFill;
            indexToFill--;
        }
    }
}
