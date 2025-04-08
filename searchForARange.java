/*
 * Problem Description
    Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
    Return an array of size 2, such that 
    First element = Left most index of B in A
    Second element = Right most index of B in A.
    If B is not found in A, return [-1, -1].

    Note : Note: The time complexity of your algorithm must be O(log n)..

    Problem Constraints
    1 <= N <= 106
    1 <= A[i], B <= 109
 */

public class searchForARange {
    public int[] searchRange(final int[] A, int B) {
        int left = findLeft(A, B);
        int right = findRight(A, B);
        return new int[]{left, right};
    }

    private static int findLeft(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                result = mid;
                high = mid - 1; // look on the left side
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findRight(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                result = mid;
                low = mid + 1; // look on the right side
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        searchForARange obj = new searchForARange();
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int[] result = obj.searchRange(A, B);
        System.out.println("Left most index: " + result[0]);
        System.out.println("Right most index: " + result[1]);
    }
}
