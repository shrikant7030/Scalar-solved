/*
 * Problem Description
    Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

    NOTE:
    Each element in the result should appear as many times as it appears in both arrays.
    The result can be in any order.

    Problem Constraints
    1 <= N, M <= 105
    1 <= A[i] <= 109
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class commonEle {
    public int[] solve(int[] A, int[] B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        Map<Integer, Integer> freqA = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();

        for (int num : A) {
            freqA.put(num, freqA.getOrDefault(num, 0) + 1);
        }
        for (int num : B) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }

        // Find intersection
        List<Integer> result = new ArrayList<>();
        for (int key : freqA.keySet()) {
            if (freqB.containsKey(key)) {
                int minFreq = Math.min(freqA.get(key), freqB.get(key));
                for (int i = 0; i < minFreq; i++) {
                    result.add(key);
                }
            }
        }

        // Convert to array if needed
        int[] finalResult = result.stream().mapToInt(i -> i).toArray();

        return finalResult;
    }

    public static void main(String[] args) {
        commonEle commonElements = new commonEle();
        int[] A = {2, 1, 4 , 10};
        int[] B = {3, 6, 2, 10, 10};
        int[] result = commonElements.solve(A, B);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 1 2 2
    }
}
