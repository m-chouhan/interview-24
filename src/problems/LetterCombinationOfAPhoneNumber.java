package problems;

import java.util.*;
import java.util.stream.Collectors;

/** Link to the problem : https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * */
public class LetterCombinationOfAPhoneNumber {
    Map<Character, char[]> characterMap =
            Map.of(
                    '2', new char[]{'a', 'b', 'c'},
                    '3', new char[]{'d', 'e', 'f'},
                    '4', new char[]{'g', 'h', 'i'},
                    '5', new char[]{'j', 'k', 'l'},
                    '6', new char[]{'m', 'n', 'o'},
                    '7', new char[]{'p', 'q', 'r', 's'},
                    '8', new char[]{'t', 'u', 'v'},
                    '9', new char[]{'w', 'x', 'y', 'z'}
            );

    public List<String> appendCharToStrings(char character, List<String> input) {
        if(input.isEmpty()) {
            return Arrays.asList(String.valueOf(character));
        }
        return input.stream().map(str -> str + character).collect(Collectors.toList());
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> solutions = new ArrayList<>();
        for(char digit : digits.toCharArray()) {
            char [] characters = characterMap.get(digit);
            ArrayList<String> updatedSolutions = new ArrayList<>();
            for(char character : characters) {
                updatedSolutions.addAll(appendCharToStrings(character, solutions));
            }
            solutions = updatedSolutions;
        }
        return solutions;
    }
}