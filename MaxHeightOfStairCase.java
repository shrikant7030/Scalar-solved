/*
 * Problem Description
    Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
    The first stair would require only one block, and the second stair would require two blocks, and so on.
    Find and return the maximum height of the staircase.

    Problem Constraints
    0 <= A <= 109
 */

public class MaxHeightOfStairCase {
    public int solve(int A) {
        int low = 0, high = A;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long blocksNeeded = (long) mid * (mid + 1) / 2; // Calculate the number of blocks needed for height mid

            if (blocksNeeded <= A) {
                ans = mid; // Update the answer
                low = mid + 1; // Try for a higher height
            } else {
                high = mid - 1; // Try for a lower height
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        MaxHeightOfStairCase obj = new MaxHeightOfStairCase();
        int A = 5; // Example input
        int result = obj.solve(A);
        System.out.println("Maximum height of staircase: " + result); // Output: 2
        // Test with a larger value of A
    }
}
