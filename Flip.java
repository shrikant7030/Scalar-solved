/*
 * Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. 
In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, 
we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
If there are multiple solutions, return the lexicographically smallest pair of L and R.
NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints

1 <= size of string <= 100000
 */


public class Flip {
    public static int[] solve(String A) {
        int l = 0, cSum = 0, maxSum = 0;
        int start = -1, end = -1, tempStart = 0;

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            cSum += (ch == '0') ? 1 : -1;

            if (cSum > maxSum) {
                maxSum = cSum;
                start = tempStart;
                end = i;
            }

            if (cSum < 0) {
                cSum = 0;
                tempStart = i + 1; // Reset start index for next possible subarray
            }
        }

        if (maxSum == 0) return new int[0]; // No beneficial flip found

        return new int[]{start + 1, end + 1};
    }

    public static void main(String[] args) {
        String A = "0111000100010"; // Example input
        int[] result = solve(A);
        
        if (result.length == 0) {
            System.out.println("No valid flip found.");
        } else {
            System.out.println("Flip from index " + result[0] + " to index " + result[1]);
        }
    }
}

