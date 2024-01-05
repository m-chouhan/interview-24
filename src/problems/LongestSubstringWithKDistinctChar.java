package problems;

import java.util.*;

/**
 * Longest substring with k distinct characters!
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 * */
public class LongestSubstringWithKDistinctChar {
    public String lengthOfLongestSubstringKDistinct(String input, int k) {
        HashMap<Character, Integer> runningWindow = new HashMap<>();
        int startIndex = 0, endIndex = 0;
        String answer = "";

        while(endIndex < input.length()) {
            char nextChar = input.charAt(endIndex);
            runningWindow.put(nextChar,
                    runningWindow.getOrDefault(nextChar, 0) + 1);
            while(runningWindow.size() > k) {
                char firstChar = input.charAt(startIndex);
                runningWindow.put(firstChar, runningWindow.get(firstChar) - 1);
                if(runningWindow.get(firstChar) <= 0) runningWindow.remove(firstChar);
                startIndex++;
            }

            int substringLength = endIndex - startIndex + 1;
            if(answer.length() < substringLength) {
                answer = input.substring(startIndex, endIndex + 1);
            }
            endIndex++;
        }
        return answer;
    }
}
