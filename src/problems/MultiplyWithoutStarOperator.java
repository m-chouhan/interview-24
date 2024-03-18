package problems;

/**
 * Goal is to perform multiply operation without
 * using * operator, also to come up with a strategy
 * to minimize the number of operations.
 * */
public class MultiplyWithoutStarOperator {

    int multiply(int a, int b) {
        int min = Math.min(a, b), max = Math.max(a, b);
        // add Max value, min times. for minimizing total operations.
        if(min == 0 || max == 0) return 0;
        if(min > 1) {
            int offsetValueForOddMultiplication = min % 2 == 0 ? 0 : max;
            return multiply(max << 1, min >> 1) + offsetValueForOddMultiplication;
        }
        return max;
    }
}
