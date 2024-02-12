package problems;

import datastructures.TrieStack;

import java.util.*;

/**
 * Word Break Problem :
 * https://leetcode.com/problems/word-break-ii/
 * */
public class WordBreakII {
    ArrayList<String> answers = new ArrayList<>();
    public List<String> wordBreak(String input, List<String> wordDict) {
        TrieStack trieStack = new TrieStack();
        for(String word : wordDict) trieStack.addWord(word);

        generateAllCombinations(input, trieStack, 0);
        return answers;
    }

    private void generateAllCombinations(String input, TrieStack trieStack,
                                                 int index) {
        if(index == input.length()) {
            if(trieStack.isValidWord())
                answers.add(trieStack.toString());
            return;
        }

        char currentChar = input.charAt(index);
        if (trieStack.peekAhead(currentChar)) {
           trieStack.push(currentChar);
           generateAllCombinations(input, trieStack, index + 1);
           trieStack.pop();
        }

        if (trieStack.peekRoot(currentChar) && trieStack.isValidWord()) {
            trieStack.push('.');
            trieStack.push(currentChar);
            generateAllCombinations(input, trieStack, index + 1);
            trieStack.pop();
            trieStack.pop();
        }
    }

}
