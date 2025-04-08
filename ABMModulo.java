/*
 * Problem Description
    Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

    Problem Constraints
    1 <= A, B <= 109
    A != B
 */

public class ABMModulo {
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }

    public static void main(String[] args) {
        ABMModulo abmModulo = new ABMModulo();
        int A = 6816621; // Example value for A
        int B = 8157697;  // Example value for B
        System.out.println(abmModulo.solve(A, B)); // Output the result
    }
}
