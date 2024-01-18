package problems;

/**
 * Best time to buy sell stock III,
 * leetcode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * */
public class BestTimeToBuySellStockIII {
    public int maxProfit(int[] prices) {
        int [] minPrices = generateMinArray(prices);
        int [] maxPrices = generateMaxArray(prices);

        int []maxProfitStart = generateMaxProfitStart(prices, minPrices);
        int []maxProfitEnd = generateMaxProfitEnd(prices, maxPrices);
        int ans = 0;
        for(int i = 0; i < prices.length; ++i) {
            int currentProfit = maxProfitStart[i] + (i == (prices.length - 1) ? 0 : maxProfitEnd[i+1]);
            ans = Math.max(ans, currentProfit);
        }
        return ans;
    }

    int [] generateMinArray(int []prices) {
        int []out = new int[prices.length];
        out[0] = prices[0];
        for(int i = 1; i < prices.length; ++i) {
            out[i] = Math.min(prices[i], out[i-1]);
        }
        return out;
    }

    int [] generateMaxArray(int []prices) {
        int []out = new int[prices.length];
        out[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; --i) {
            out[i] = Math.max(prices[i], out[i+1]);
        }
        return out;
    }

    int [] generateMaxProfitStart(int []prices, int []minPrices) {
        int []maxProfit = new int[prices.length];
        maxProfit[0] = 0;
        for(int i = 1; i < prices.length; ++i) {
            maxProfit[i] = Math.max(
                    maxProfit[i-1],
                    prices[i] - minPrices[i-1]
            );
        }
        return maxProfit;
    }

    int [] generateMaxProfitEnd(int []prices, int []maxPrices) {
        int []maxProfit = new int[prices.length];
        maxProfit[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; --i) {
            maxProfit[i] = Math.max(
                    maxProfit[i+1],
                    maxPrices[i+1] - prices[i]
            );
        }
        return maxProfit;
    }
}
