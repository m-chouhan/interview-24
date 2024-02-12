package problems;

import java.util.*;

/**
 * Minimum cost for coloring houses with k colors.
 * https://leetcode.com/problems/paint-house-ii/
 */
public class MinCostOfColoringHouse {
    class Data {
        int k;
        int value;
        Data(int k, int value) {
            this.k = k; this.value = value;
        }
    };

    Data [][] minCostAt;

    public int minCostII(int[][] costs) {
        final int N = costs.length, K = costs[0].length;
        int [][] minCost = new int[N][K];
        minCostAt = new Data[N][2];

        for(int [] arr : minCost)
            Arrays.fill(arr, Integer.MAX_VALUE);

        for(int n = 0; n < N; ++n)
            for(int k = 0; k < K; ++k) {
                if(n == 0)
                    minCost[n][k] = costs[n][k];
                else {
                    minCost[n][k] = minCostAt[n-1][0].k == k
                            ? costs[n][k] + minCostAt[n-1][1].value
                            : costs[n][k] + minCostAt[n-1][0].value;
                }
                updateMinCost(n, k, minCost[n][k]);
            }

        return minCostAt[N-1][0].value;
    }

    void updateMinCost(int n, int k, int value) {
        Data data = new Data(k, value);
        if(minCostAt[n][0] == null) minCostAt[n][0] = data;
        else if(minCostAt[n][1] == null || minCostAt[n][1].value > value) {
            minCostAt[n][1] = data;
            if(minCostAt[n][0].value > value)
                swap(minCostAt[n]);
        }
    }

    void swap(Data [] dataPair) {
        Data temp = dataPair[0];
        dataPair[0] = dataPair[1];
        dataPair[1] = temp;
    }
}
