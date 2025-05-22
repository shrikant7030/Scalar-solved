/*
 * Problem Description
    Given a sorted array of integers A of size N and an integer B, 
    where array A is rotated at some pivot unknown beforehand.
    For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
    Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
    You can assume that no duplicates exist in the array.
    NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

    Problem Constraints
    1 <= N <= 1000000
    1 <= A[i] <= 109
    All elements in A are Distinct.
 */

package Searching;

public class RotatedSortedArray {
    public int search(final int[] A, int B) {
        int low = 0, high = A.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(A[mid] == B) {
                return mid; // Found the target
            } else if(A[mid] < B) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArray obj = new RotatedSortedArray();
        int[] A = {4, 5, 6, 7, 0, 1, 2}; // Example input
        int B = 0; // Target value to search for
        int result = obj.search(A, B);
        System.out.println("Index of " + B + ": " + result); // Output: index of the target value
        // Test with a different array and target value
    }
    
}
