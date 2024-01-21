package problems;

import java.util.*;

/**
 * Interleaving problem : https://leetcode.com/problems/interleaving-string
 */
public class CheckingInterleavingString {
    String A, B, target;
    int [][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        this.A = s1; this.B = s2; this.target = s3;
        if(A.length() + B.length() != target.length())
            return false;

        cache = new int[A.length() + 1][B.length() + 1];
        for (int[] ints : cache) Arrays.fill(ints, -1);

        return checkInterleaving(0, 0);
    }

    boolean checkInterleaving(int left, int right) {
        int targetIndex = left + right;
        if(targetIndex == target.length()) return true;
        if(cache[left][right] != -1)
            return cache[left][right] == 1;

        boolean checkLeft =
                left < A.length() && target.charAt(targetIndex) == A.charAt(left) && checkInterleaving(left + 1, right);
        boolean checkRight =
                right < B.length() && target.charAt(targetIndex) == B.charAt(right) && checkInterleaving(left, right + 1);

        cache[left][right] = (checkLeft || checkRight) ? 1 : 0;
        return cache[left][right] == 1;
    }
}
