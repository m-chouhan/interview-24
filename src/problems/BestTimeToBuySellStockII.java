package problems;

/***
 * Added Solution of best time to buy and sell stocks leetcode problem.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuySellStockII {

    int findBuyIndex(int index, int [] prices) {
        int lastIndex = prices.length - 1;
        while(index < lastIndex) {
            if(prices[index] < prices[index+1]) return index;
            index++;
        }
        return lastIndex;
    }

    int findSellIndex(int index, int [] prices) {
        int lastIndex = prices.length - 1;
        while(index < lastIndex) {
            if(prices[index] > prices[index+1]) return index;
            index++;
        }
        return lastIndex;
    }

    public int maxProfit(int[] prices) {

        if(prices.length <= 1) return 0;

        int index = 0, profit = 0;

        while(index < prices.length) {
            int buyIndex = findBuyIndex(index, prices);
            int sellIndex = findSellIndex(buyIndex + 1, prices);
            profit += prices[sellIndex] - prices[buyIndex];
            index = sellIndex+1;
        }
        return profit;
    }
}
