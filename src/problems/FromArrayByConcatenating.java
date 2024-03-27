package problems;

/**
 * https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/description/
 * */
public class FromArrayByConcatenating {
    public boolean canChoose(int[][] groups, int[] nums) {
        int nextIndex = 0;
        for(int [] group : groups) {
            nextIndex = findMatch(nums, group, nextIndex);
            if(nextIndex == -1) return false;
        }
        return true;
    }

    int findMatch(int []nums, int[] group, int startIndex) {
        for(int i = startIndex; (i + group.length) <= nums.length; ++i) {
            if(match(nums, group, i)) return i + group.length;
        }
        return -1;
    }

    boolean match(int [] nums, int []group, int numIndex) {
        int i = numIndex, j = 0;
        while(
                i < nums.length
                        && j < group.length
                        && nums[i] == group[j]) {
            i++;j++;
        }
        return j == group.length;
    }
}