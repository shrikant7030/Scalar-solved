/*
 * Problem Description
    You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 109
 */

import java.util.HashMap;

public class countUniqueEle {
    public int solve(int[] A) {
        int count = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count elements with frequency 1
        for (int freq : frequencyMap.values()) {
            if (freq == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        countUniqueEle uniqueElements = new countUniqueEle();
        int[] A = {1, 2, 3, 1, 2, 4}; // Example input
        int result = uniqueElements.solve(A);
        System.out.println("Count of elements with frequency 1: " + result); // Output: 2 (3 and 4)
    }
}
