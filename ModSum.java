/*
 * Problem Description
    Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.

    Problem Constraints
    1 <= length of the array A <= 105
    1 <= A[i] <= 103
 */

import java.util.Scanner;

public class ModSum {
    static final int MOD = 1_000_000_007;
    static final int MAX_VAL = 1000;

    public static int calculateModuloSum(int[] A) {
        int[] freq = new int[MAX_VAL + 1];
        
        // Count frequencies
        for (int num : A) {
            freq[num]++;
        }

        long sum = 0;

        for (int i = 1; i <= MAX_VAL; i++) {
            if (freq[i] == 0) continue;
            for (int j = 1; j <= MAX_VAL; j++) {
                if (freq[j] == 0) continue;
                sum = (sum + ((long)(i % j) * freq[i] % MOD * freq[j]) % MOD) % MOD;
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        System.out.println(calculateModuloSum(A));
    }
}
