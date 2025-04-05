/*
 * Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109
 */

import java.util.Arrays;

public class MinXorVal {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            int xorValue = A[i] ^ A[i - 1];
            minXor = Math.min(minXor, xorValue);
        }
        return minXor;
    }

    public static void main(String[] args) {
        MinXorVal minXorVal = new MinXorVal();
        int[] A = {0, 2, 5, 7};
        int result = minXorVal.findMinXor(A);
        System.out.println("Minimum XOR value: " + result); // Output: 2
    }
}
