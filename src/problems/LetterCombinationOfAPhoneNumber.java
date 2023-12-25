package problems;

import java.util.*;

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
        ArrayList<String> output = new ArrayList<>();
        if(input.isEmpty()) {
            output.add(String.valueOf(character));
            return output;
        }

        for(String str : input) {
            output.add(str + character);
        }
        return output;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> solutions = new ArrayList<>();
        for(int i = 0; i < digits.length(); ++i) {
            char digit = digits.charAt(i);
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