/*
 * Problem Description
    You are given a sorted array A of size N and a target value B.
    Your task is to find the index (0-based indexing) of the target value in the array.
    If the target value is present, return its index.
    If the target value is not found, return the index of least element greater than equal to B.
    If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
    Your solution should have a time complexity of O(log(N)).

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 105
    1 <= B <= 10
 */

public class SortedInsertionPosition {
    public int searchInsert(int[] A, int B) {
        int n = A.length;
        int low = 0; int high = n - 1;

        while( low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == B) {
                return mid;
            } else if(A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SortedInsertionPosition obj = new SortedInsertionPosition();
        int[] A = {1, 3, 4, 6};
        int B = 5; // Example input
        int result = obj.searchInsert(A, B);
        System.out.println("Insertion position: " + result); // Output: 2 (index of 5 in the array)
    // Test with a value not present in the array
    }
}
