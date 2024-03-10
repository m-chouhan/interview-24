package problems;

import java.util.*;

/**
 * Random Weighted Nodes Problem (recently asked in Uber) :
 * https://leetcode.com/problems/random-pick-with-weight/description/
 * */
public class RandomWeightedNodesUber {
    public class WeightedNode {
        int value;
        int lastIndex;
        public WeightedNode(int value, int lastIndex) {
            this.value = value;
            this.lastIndex = lastIndex;
        }
    }

    Random random;
    WeightedNode [] nodes;
    int maxIndex;
    public RandomWeightedNodesUber(int[] w) {
        random = new Random();
        nodes = new WeightedNode[w.length];
        for(int i = 0; i < w.length; ++i)
            nodes[i] = new WeightedNode(i, i > 0 ? w[i] + nodes[i -1].lastIndex : w[i]);
        maxIndex = nodes[nodes.length - 1].lastIndex;
    }

    public int pickIndex() {
        int randomInt = random.nextInt(maxIndex);
        WeightedNode node = search(randomInt, 0, nodes.length);
        return node.value;
    }

    WeightedNode search(int searchIndex, int left, int right) {
        if(left == right) return nodes[left];

        int mid = (left + right) / 2;
        if(searchIndex < nodes[mid].lastIndex) return search(searchIndex, left, mid);
        return search(searchIndex, mid + 1, right);
    }
}
