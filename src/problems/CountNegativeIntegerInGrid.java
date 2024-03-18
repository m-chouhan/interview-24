package problems;

/**
 * Count number of negative integer in a grid which is sorted
 * in non-increasing order. (row & column wise)
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * */
public class CountNegativeIntegerInGrid {
    public int countNegatives(int[][] grid) {
        int negativeCount = 0;
        int index = findLastPositiveIndex(grid[0]);
        negativeCount = grid[0].length - index - 1;

        for(int i = 1; i < grid.length; ++i) {
            while(index >= 0 && grid[i][index] < 0)
                index--;
            negativeCount +=
                    grid[0].length - index - 1;
        }

        return negativeCount;
    }

    int findLastPositiveIndex(int [] row) {
        int left = 0, right = row.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(row[mid] >= 0)
                left = mid+1;
            else right = mid;
        }
        return left - 1;
    }
}
