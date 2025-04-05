/* Problem Description
Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that
a1 >= a2 <= a3 >= a4 <= a5..... 
NOTE: If multiple answers are possible, return the lexicographically smallest one.

Problem Constraints
1 <= len(A) <= 106
0 <= A[i] <= 106 */

import java.util.Arrays;

public class waveArray {
    // Function to sort the array into a wave-like pattern
    public static int[] wave(int[] A) {
        // Sort the array
        Arrays.sort(A);
        
        // Swap adjacent elements to create a wave-like pattern
        for (int i = 0; i < A.length - 1; i += 2) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }
        
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 3, 2, 4};
        int[] result = wave(A);
        System.out.println(Arrays.toString(result)); // Output: [2, 1, 4, 3, 5]
    }
}

