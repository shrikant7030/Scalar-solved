/* Problem Description
Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109 */

import java.util.Arrays;


import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class TensDigitSorting {

    // Function to get the tens digit of a number
    public static int[] sortByTensDigit(int[] A) {
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Get the tens digit of both numbers
                int tensA = (a / 10) % 10;
                int tensB = (b / 10) % 10;

                // Compare based on tens digit first, then by value
                if (tensA != tensB) {
                    return Integer.compare(tensA, tensB);
                } else {
                    return Integer.compare(b, a); // Descending order for same tens digit
                }
            }
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {15, 11, 7, 19};
        int[] result = sortByTensDigit(A);
        
        System.out.println("Sorted by Tens Digit:");
        System.out.println(Arrays.toString(result));
    }
}
