/*
 * Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Problem Constraints
1 <= A <= 5000
 */

public class NthMagicNumber {
    public int solve(int A) {
        int magicNumber = 0;
        int power = 1;

        while (A > 0) {
            power *= 5;
            if((A & 1) == 1) {
                magicNumber += power;
            }
            A >>= 1;
        }

        return magicNumber;
    }

    public static void main(String[] args) {
        NthMagicNumber nthMagicNumber = new NthMagicNumber();
        int A = 5; // Example input
        int result = nthMagicNumber.solve(A);
        System.out.println("The " + A + "th magic number is: " + result);
    }
}
