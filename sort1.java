/* 
 * Problem Description
Given an array A of 0s and 1s of length N. Sort this array.
Note - Do not use any sorting algorithm or library's sort method.

Problem Constraints
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 1
 */


public class sort1 {
    public int[] sort01(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int index = 0;

        // Count the number of 0s and 1s
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                result[index++] = 0;
            }
        }
        while (index < n) {
            result[index++] = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        sort1 sorter = new sort1();
        int[] A = {0, 1, 0, 1, 0, 1};
        int[] sortedArray = sorter.sort01(A);

        System.out.println("Sorted Array: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Output: Sorted Array: 0 0 0 1 1 1
    }
}