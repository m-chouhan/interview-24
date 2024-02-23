package problems;
import java.util.*;

/**
 * https://leetcode.com/problems/brick-wall/
 * Minimum cost to cut Brick Wall
 * */
public class BrickWall {
    int computeWidth(List<Integer> row) {
        int size = 0;
        for(int cell : row)
            size += cell;
        return size;
    }

    public int leastBricks(List<List<Integer>> wall) {
        final int wallWidth = computeWidth(wall.get(0));
        int []costOfCutting = new int[wallWidth];

        for(int rowIndex = 0; rowIndex < wall.size(); rowIndex++) {
            int lastBrickSize = 0;
            for(int colIndex = 0; colIndex < wall.get(rowIndex).size(); colIndex++) {
                int brickSize = wall.get(rowIndex).get(colIndex);
                int nextBrickSize = lastBrickSize + brickSize;
                for(int cuttingIndex = lastBrickSize + 1;
                    cuttingIndex < nextBrickSize;
                    cuttingIndex++) {
                    costOfCutting[cuttingIndex]++;
                }
                lastBrickSize = nextBrickSize;
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i < costOfCutting.length; ++i)
            minCost = Math.min(costOfCutting[i], minCost);
        if(minCost == Integer.MAX_VALUE) {
            minCost = wall.size();
        }
        return minCost;
    }
}
