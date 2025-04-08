/*
 * Problem Description
    Given an array of integers A, find and return the peak element in it.
    An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

    NOTE:
    It is guaranteed that the array contains only a single peak element.
    Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 109
 */

public class FindAPeakElement {
    public int solve(int[] A) {

        int n = A.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Handle boundary cases
            boolean leftOk = (mid == 0 || A[mid] > A[mid - 1]);
            boolean rightOk = (mid == n - 1 || A[mid] > A[mid + 1]);

            if (leftOk && rightOk) {
                return A[mid]; // A[mid] is a peak
            } else if (mid < n - 1 && A[mid] < A[mid + 1]) {
                // Peak is on the right
                low = mid + 1;
            } else {
                // Peak is on the left
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindAPeakElement obj = new FindAPeakElement();
        int[] A = {1,1000000000,1000000000}; // Example input
        int result = obj.solve(A);
        System.out.println("Peak element index: " + result); // Output: index of the peak element
        // Test with a different array
    }
}
