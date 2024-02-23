package problems;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Input : sorted array with -ve integers
 * Output : sorted array with squares
 */
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int [] answer = new int[nums.length];
        int midPoint = midPoint(nums);
        int leftIndex = midPoint - 1, rightIndex = midPoint;
        int writeIndex = 0;
        while(writeIndex < answer.length) {
            int nextValue = 0;
            if(leftIndex < 0)
                nextValue = nums[rightIndex++];
            else if(rightIndex >= nums.length)
                nextValue = nums[leftIndex--];
            else if(Math.abs(nums[leftIndex]) > nums[rightIndex])
                nextValue = nums[rightIndex++];
            else
                nextValue = nums[leftIndex--];

            answer[writeIndex] = nextValue * nextValue;
            writeIndex++;
        }
        return answer;
    }

    int midPoint(int [] nums) {
        for(int i = 0; i < nums.length; ++i)
            if(nums[i] >= 0) return i;
        return nums.length;
    }
}
