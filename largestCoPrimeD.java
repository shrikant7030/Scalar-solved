/*
 * 
 * Problem Description
    You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
    X divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1

    Problem Constraints
    1 <= A, B <= 109
 */


public class largestCoPrimeD {
    public int cpFact(int A, int B) {
        // Function to find the GCD of two numbers
        int gcd = gcd(A, B);
        // Divide A by the GCD until it is no longer divisible
        while (gcd != 1) {
            A /= gcd;
            gcd = gcd(A, B);
        }
        return A;
    }

    // Helper function to calculate GCD using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        largestCoPrimeD obj = new largestCoPrimeD();
        int A = 30; // Example input
        int B = 12; // Example input
        int result = obj.cpFact(A, B);
        System.out.println("Largest co-prime divisor: " + result); // Output: 5
    }
}