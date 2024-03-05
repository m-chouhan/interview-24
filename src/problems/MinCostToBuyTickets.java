package problems;

/** Added solution to min cost to buy tickets. (dp)
 *  https://leetcode.com/problems/minimum-cost-for-tickets/
 * */
public class MinCostToBuyTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int [] minCostArray = new int[days.length];
        minCostArray[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for(int i = 1; i < days.length; ++i) {
            int day1PassCost = costs[0] + minCostArray[i-1];
            int day7PassCost = costs[1] + findNthDayCost(days, minCostArray, i, 7);
            int day30PassCost = costs[2] + findNthDayCost(days, minCostArray, i, 30);
            minCostArray[i] = Math.min(day1PassCost, Math.min(day7PassCost, day30PassCost));
        }
        return minCostArray[minCostArray.length - 1];
    }

    int findNthDayCost(int [] days, int []minCost, int index, int dayCount) {
        for(int i = index; i >= 0; --i) {
            if((days[index] - days[i]) >= dayCount) return minCost[i];
        }
        return 0;
    }

}
