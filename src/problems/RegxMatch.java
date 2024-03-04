package problems;

/**
 * Solution for regular expression matching problem on leetcode.
 * https://leetcode.com/problems/regular-expression-matching/description/
 */
public class RegxMatch {
    String input, regx;
    int [][] cache;

    public boolean isMatch(String input, String regx) {
        this.input = input; this.regx = regx;
        this.cache = new int[input.length() + 1][regx.length() + 1];
        return isMatch(input.length(), regx.length());
    }

    boolean isMatch(int inputLen, int regxLen) {
        if(cache[inputLen][regxLen] != 0)
            return cache[inputLen][regxLen] == 1;
        boolean answer = false;

        if(inputLen == 0 && regxLen == 0) {
            answer = true;
        } else if(inputLen == 0 || regxLen == 0) {
            answer = isIgnorableRegx(regxLen);
        } else {
            char inputChar = input.charAt(inputLen - 1);
            char regxChar = regx.charAt(regxLen - 1);
            if(regxChar == '*') {
                if(isMatch(inputChar, regx.charAt(regxLen - 2))) {
                    answer =
                            isMatch(inputLen - 1, regxLen - 2) ||
                                    isMatch(inputLen - 1, regxLen) ||
                                    isMatch(inputLen, regxLen - 2);
                } else {
                    answer = isMatch(inputLen, regxLen - 2);
                }
            } else if(isMatch(inputChar, regxChar)) {
                answer = isMatch(inputLen - 1, regxLen - 1);
            }
        }

        cache[inputLen][regxLen] = answer ? 1 : -1;
        return answer;
    }

    boolean isMatch(char input, char regx) {
        if(regx == '.') return true;
        return input == regx;
    }

    boolean isIgnorableRegx(int regxLen) {
        if(regxLen % 2 != 0) return false;
        for(int i = 1; i < regxLen; i += 2)
            if(regx.charAt(i) != '*') return false;
        return true;
    }
}
