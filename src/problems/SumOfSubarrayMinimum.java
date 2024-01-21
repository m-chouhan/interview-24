package problems;

import java.util.*;

/**
 * Sum of subarray minimum :
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums">...</a>
 */
public class SumOfSubarrayMinimum {
    int MOD = 1000000007;

    class Info {
        public int value;
        public int index;
        Info(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    Info [] findSmallerNumbers(int []array) {
        Stack<Info> stack = new Stack<>();
        Info []answer = new Info[array.length];
        for(int i = 0; i < array.length; ++i) {
            while(!stack.isEmpty() && stack.peek().value >= array[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? new Info(-1, -1) : stack.peek();
            stack.push(new Info(array[i], i));
        }
        return answer;
    }

    public int sumSubarrayMins(int[] array) {
        Info [] lastSmallestNumber = findSmallerNumbers(array);
        int [] subarraySum = new int[array.length];

        for(int i = 0; i < array.length; ++i) {
            int lastSmallestIndex = lastSmallestNumber[i].index;
            int currentSum = lastSmallestIndex == -1
                    ? array[i] * (i + 1) // current number is the smallest
                    : subarraySum[lastSmallestIndex] + (i - lastSmallestIndex) * array[i];
            subarraySum[i] = currentSum;
        }

        int total = 0;
        for (int sum : subarraySum) {
            total += sum % MOD;
            total %= MOD;
        }
        return total;
    }

    public int sumSubarrayMinsII(int [] array) {
        int total = 0;
        for(int i = 0; i < array.length; ++i) {
            int min = array[i];
            for(int j = i; j >= 0; j--) {
                min = Math.min(array[i], min);
                total += min;
            }
        }
        return total;
    }
}
