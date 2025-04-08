/*
 * 
 * Problem Description
    You are given an array A of N integers and an integer B.
    Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
    Since the answer can be very large, return the remainder after dividing the count with 109+7.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 109
    1 <= B <= 109
 */

import java.util.HashMap;

public class countPairDiff {
    public int solve(int[] A, int B) {
        int count = 0;
        int mod = 1000000007;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count pairs (i, j) such that A[i] - A[j] = B
        for (int num : A) {
            int target = num - B;
            if (frequencyMap.containsKey(target)) {
                count = (count + frequencyMap.get(target)) % mod;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        countPairDiff pairDiff = new countPairDiff();
        int[] A = {1, 2, 3, 4, 5}; // Example input
        int B = 2; // Example difference
        int result = pairDiff.solve(A, B);
        System.out.println("Count of pairs with difference " + B + ": " + result); // Output: 4 (pairs: (3,1), (4,2), (5,3), (2,0))
    }
    // Output: 4 (pairs: (3,1), (4,2), (5,3), (2,0))
}
