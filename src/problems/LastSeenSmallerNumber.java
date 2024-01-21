package problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find leftmost smaller number in an array.
 * Suppose you are given an array [2, 1, 3, 2, 1, 3]
 * output should be [-1, -1, 2, 1, -1, 2]
 */
public class LastSeenSmallerNumber {

    class Info {
        public int value;
        public int index;
        Info(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    int [] findSmallerNumbers(int []array) {
        Stack<Info> stack = new Stack<>();
        Info []answer = new Info[array.length];
        for(int i = 0; i < array.length; ++i) {
            while(!stack.isEmpty() && stack.peek().value >= array[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? new Info(-1, -1) : stack.peek();
            stack.push(new Info(array[i], i));
        }
        return Arrays.stream(answer).mapToInt(info -> info.value).toArray();
    }
}
