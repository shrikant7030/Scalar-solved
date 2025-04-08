/*
 * Problem Description
    Scooby has 3 three integers A, B, and C.
    Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
    You need to tell the number of special integers less than or equal to A.

    Problem Constraints
    1 <= A, B, C <= 109
 */

public class DiviserGame {
    public int solve(int A, int B, int C) {
        // Calculate the LCM of B and C
        int lcm = lcm(B, C);
        // Count the number of multiples of lcm less than or equal to A
        return A / lcm;
    }
    
}
