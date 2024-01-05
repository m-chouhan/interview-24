package problems;

import java.util.*;

public class WordBreak {
    HashMap<String, Boolean> subproblems = new HashMap<>();

    public boolean wordBreak(String input, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordDict) {
            wordSet.add(word);
            subproblems.put(word, true);
        }
        return isValid(input, wordSet);
    }

    boolean isValid(String input, Set<String> wordSet) {
        if(subproblems.containsKey(input))
            return subproblems.get(input);

        for(int i = 1; i < input.length(); ++i) {
            String left = input.substring(0, i);
            String right = input.substring(i + 1, input.length() - 1);
            if(isValid(left, wordSet) && isValid(right, wordSet)) {
                subproblems.put(input, true);
                return true;
            }
        }

        subproblems.put(input, false);
        return false;
    }
}
