package problems;
import java.util.*;

/**
 * Leetcode : https://leetcode.com/problems/edit-distance/
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * */
public class MinimumEditDistance {
    String source, target;
    int [][]cache;
    public int minDistance(String word1, String word2) {
        source = word1;
        target = word2;
        cache = new int[source.length()+1][target.length()+1];
        for(int i = 0; i < cache.length; ++i)
            Arrays.fill(cache[i], -1);
        return minDistance(source.length(), target.length());
    }

    public int minDistance(int sourceLen, int targetLen) {
        if(Math.min(sourceLen, targetLen) == 0)
            return Math.max(sourceLen, targetLen);
        if(cache[sourceLen][targetLen] != -1)
            return cache[sourceLen][targetLen];

        // you are adding a char at the END of source len.
        int insertCost = minDistance(sourceLen, targetLen - 1) + 1;
        // you are removing a char from the END of source len.
        int removalCost = minDistance(sourceLen - 1, targetLen) + 1;
        // you are replacing a char at the END to match the END char of target.
        int replaceOperationCost =
                source.charAt(sourceLen - 1) == target.charAt(targetLen - 1) ? 0 : 1;
        int replaceCost = minDistance(sourceLen - 1, targetLen - 1) + replaceOperationCost;

        cache[sourceLen][targetLen] =
                Math.min(Math.min(insertCost, removalCost), replaceCost);
        return cache[sourceLen][targetLen];
    }
}
