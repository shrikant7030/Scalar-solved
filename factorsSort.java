/*  Problem Description

You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, 
i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. 
If 2 elements have same number of factors, then number with less value should come first.
Note: You cannot use any extra space

Problem Constraints
1 <= N <= 104
1 <= A[i] <= 104 */ 

import java.util.Arrays;

public class Solution {
   public int[] solve(int[] A) {
        int N = A.length;
        Integer[] indices = new Integer[N];

        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> {
            int factorsI = countFactors(A[i]);
            int factorsJ = countFactors(A[j]);

            if (factorsI == factorsJ) {
                return Integer.compare(A[i], A[j]);
            }
            return Integer.compare(factorsI, factorsJ);
        });

        int[] sortedArray = new int[N];
        for (int i = 0; i < N; i++) {
            sortedArray[i] = A[indices[i]];
        }

        return sortedArray;
    }

    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }
}
public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {12, 6, 8, 4, 10};
		int[] sortedArray = solution.solve(A);
		System.out.println(Arrays.toString(sortedArray));
}
