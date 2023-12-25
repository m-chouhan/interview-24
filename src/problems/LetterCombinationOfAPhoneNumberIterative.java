package problems;

import java.util.*;

/**
 * Link to the problem : https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * */
public class LetterCombinationOfAPhoneNumberIterative {

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

    public static class StackFrame {
        int index = 0;
        char [] characters;
        StackFrame(int index, char []characters) {
            this.index = index;
            this.characters = characters;
        }

        boolean increment() {
            index++;
            return index < characters.length;
        }

        char getChar() {
            return characters[index];
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();

        char [] inputArray = digits.toCharArray();
        ArrayList<String> solutions = new ArrayList<>();
        ArrayDeque<StackFrame> stack = new ArrayDeque<>();
        do {
            initStack(stack, inputArray);
            solutions.add(generateStringFromStack(stack));
            updateStackCounters(stack);
        } while (!stack.isEmpty());

        return solutions;
    }

    private void initStack(ArrayDeque<StackFrame> stack, char [] inputArray) {
        while(stack.size() < inputArray.length) {
            char ch = inputArray[stack.size()];
            stack.push(new StackFrame(0, characterMap.get(ch)));
        }
    }

    private void updateStackCounters(ArrayDeque<StackFrame> stack) {
        while(!stack.isEmpty() && !stack.getFirst().increment()) {
            stack.removeFirst();
        }
    }

    private String generateStringFromStack(ArrayDeque<StackFrame> stack) {
        StringBuilder builder = new StringBuilder();
        Iterator<StackFrame> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next().getChar());
        }
        return builder.toString();
    }
}
