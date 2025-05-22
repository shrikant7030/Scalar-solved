/*
 * Problem Description
    Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
    Elements which are appearing twice are adjacent to each other.
    NOTE: Users are expected to solve this in O(log(N)) time.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 10^9
 */

public class SingleEleInSortedArray {
    public int solve(int[] A) {
        int n = A.length;
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            if(mid % 2 == 1) {
                mid--;
            }

            if(A[mid] == A[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return A[low]; // The single element is at index low (or high, since low == high)
    }
    
    public static void main(String[] args) {
        SingleEleInSortedArray obj = new SingleEleInSortedArray();
        int[] A = {1, 1, 2, 2, 3, 3, 4}; // Example input
        int result = obj.solve(A);
        System.out.println("Single element: " + result); // Output: single element that appears once
    }
}
