package problems;

import java.util.*;

/**
 * Best time to buy and sell stocks.
 * Leetcode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuySellStock {

    /***
     * Approach 1 : Using Stack Data Structure.
     */
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxProfit = 0;
        for(int currentPrice : prices) {
            while(!stack.isEmpty() && stack.getFirst() > currentPrice) {
                maxProfit = Math.max(maxProfit, stack.getFirst() - stack.getLast());
                stack.pop();
            }
            stack.push(currentPrice);
        }

        return Math.max(maxProfit, stack.getFirst() - stack.getLast());
    }

    /**
     * Approach II : Using multiple arrays for storing smallest left and largest right.
     */
    public int maxProfitII(int [] prices) {
        int [] minArrayLeft = createMinArray(prices);
        int [] maxArrayRight = createMaxArray(prices);
        int maxProfit = 0;
        for(int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, maxArrayRight[i] - minArrayLeft[i-1]);
        }
        return maxProfit;
    }

    int [] createMinArray(int [] prices) {
        int [] out = new int [prices.length];
        for(int i = 0; i < prices.length; ++i)
            out[i] = i > 0 ? Math.min(prices[i], out[i-1]) : prices[i];
        return out;
    }

    int [] createMaxArray(int [] prices) {
        int [] out = new int [prices.length];
        for(int i = prices.length - 1; i >= 0; --i) {
            out[i] = i < (prices.length - 1) ? Math.max(prices[i], prices[i+1]) : prices[i];
        }
        return out;
    }
}
