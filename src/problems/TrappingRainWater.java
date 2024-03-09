package problems;

/*
* Solution to trapping rain water problem on leetcode.
* https://leetcode.com/problems/trapping-rain-water/description/
* */
public class TrappingRainWater {
    public int trap(int[] height) {
        final int n = height.length;
        int []leftLargest = new int[n];
        int []rightLargest = new int[n];

        leftLargest[0] = height[0];
        for(int i = 1; i < n; ++i)
            leftLargest[i] = Math.max(leftLargest[i - 1], height[i]);
        rightLargest[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rightLargest[i] = Math.max(rightLargest[i + 1], height[i]);

        int totalWater = 0;
        for(int i = 1; i < n - 1; ++i) {
            int waterOnCurrentIndex = Math.min(leftLargest[i - 1], rightLargest[i + 1]) - height[i];
            if(waterOnCurrentIndex > 0) totalWater += waterOnCurrentIndex;
        }
        return totalWater;
    }
}
