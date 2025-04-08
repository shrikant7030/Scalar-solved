/*
 * Problem Description
    Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
    This matrix A has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than or equal to the last integer of the previous row.
    Return 1 if B is present in A, else return 0.

    NOTE: Rows are numbered from top to bottom, and columns are from left to right.

    Problem Constraints
    1 <= N, M <= 1000
    1 <= A[i][j], B <= 106
 */

public class MatrixSearchBinary {
    public int searchMatrix ( int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = A[mid / m][mid % m]; // Convert 1D index to 2D index

            if (midValue == B) {
                return 1; // Found the element
            } else if (midValue < B) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return 0; // Element not found
    }

    public static void main(String[] args) {
        MatrixSearchBinary obj = new MatrixSearchBinary();
        int[][] A = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        int B = 9; // Example input
        int result = obj.searchMatrix(A, B);
        System.out.println("Element found: " + result); // Output: 1 (element found)
    }
}
