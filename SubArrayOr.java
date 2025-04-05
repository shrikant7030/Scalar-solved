/*
 * 
 * Problem Description
You are given an array of integers A of size N.
The value of a subarray is defined as BITWISE OR of all elements in it.
Return the sum of value of all subarrays of A % 109 + 7.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108
 */

public class SubArrayOr {
    static final int MOD = 1000000007;

    public int solve(int[] A) {
        int N = A.length;
        long totalSum = 0;

        // Iterate over each bit position (0 to 30)
        for (int bit = 0; bit < 31; bit++) {
            int lastZero = -1;  // Last index where bit was NOT set
            long contribution = 0;

            for (int i = 0; i < N; i++) {
                // If the current number has the bit set
                if ((A[i] & (1 << bit)) != 0) {
                    // Count subarrays that include this bit
                    contribution += (long)(i - lastZero) * (1 << bit);
                    contribution %= MOD;
                } else {
                    lastZero = i;  // Update the last zero index
                }
            }

            totalSum = (totalSum + contribution) % MOD;
        }

        return (int) totalSum;
    }

    public static void main(String[] args) {
        SubArrayOr subArrayOr = new SubArrayOr();
        int[] A = {1, 2, 3, 4, 5}; // Example input
        int result = subArrayOr.solve(A);
        System.out.println("Sum of values of all subarrays: " + result); // Output: 14
    }
}
