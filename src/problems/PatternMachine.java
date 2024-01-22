package problems;

import java.util.*;

/**
 * Count the number of occurrences of pattern in a given input string.
 */
public class PatternMachine {
    int patternMatch(String pattern, String source) {

        if(pattern.isEmpty()) return 0;

        Set<Character> vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char [] array = source.toCharArray();
        char [] transformedArray = new char[array.length];
        for(int i = 0; i < array.length; ++i)
            transformedArray[i] = vowelSet.contains(array[i]) ? '0' : '1';
        char [] patternArray = pattern.toCharArray();

        return countPatterns(patternArray, transformedArray);
    }

    int countPatterns(char [] pattern, char []source) {
        int count = 0;
        for(int i = 0; i < source.length; ++i) {
            count += match(pattern, source, i) ? 1 : 0;
        }
        return count;
    }

    boolean match(char [] pattern, char [] source, int startIndex) {
        if(source.length < (startIndex + pattern.length)) return false;

        for(int i = 0; i < pattern.length; ++i) {
            if (pattern[i] != source[i + startIndex]) return false;
        }
        return true;
    }
}
