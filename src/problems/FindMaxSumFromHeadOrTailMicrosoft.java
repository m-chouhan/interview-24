package problems;

/**
 * Recently asked at microsoft :
 * https://stackoverflow.com/questions/71887151/find-the-max-sum-of-removed-elements-from-head-or-tail
 * */
public class FindMaxSumFromHeadOrTailMicrosoft {

    int findMaxSum(int []array, int k) {
        int sum = 0;
        for(int i = 0; i < k; ++i) {
            sum += array[i];
        }
        int maxSum = sum;
        for(int i = 1; i <= k; ++i) {
            sum -= array[k - i];
            sum += array[array.length - i];
            maxSum = Math.max(sum , maxSum);
        }
        return maxSum;
    }
}
