package problems;

import java.util.*;

/* Find next greater element in a circular array.
*  https://leetcode.com/problems/next-greater-element-ii/
* */
public class NextGreaterElementInCircularArray {
    public int[] nextGreaterElements(int[] nums) {
        final int largestIndex = findLargest(nums);
        Stack<Integer> stack = new Stack<>();
        final int [] ans = new int[nums.length];

        for(int i = largestIndex, count = 0; count < nums.length; ++count) {
            int value = nums[i];
            while(!stack.isEmpty() && stack.peek() <= value)
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(value);
            i = (i == 0) ? nums.length - 1 : i - 1;
        }
        return ans;
    }

    int findLargest(int [] nums) {
        int largestNum = Integer.MIN_VALUE, largestIndex = -1;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > largestNum) {
                largestNum = nums[i];
                largestIndex = i;
            }
        }
        return largestIndex;
    }
}
