/*
 * Problem Description
Print N numbers in Decreasing Order and then in Increasing Order.
You are given a positive number N.
You are required to print the numbers from N to 1.
You are required to not use any loops. Don't change the signature of the function DecThenInc function.
Note : Please print an new line after printing the output.

Problem Constraints
1 <= N <= 100
 */

public class DecNInc {

    public void DecThenInc(int A) {
        DecThenIncHelper(A, A);
        System.out.println(); // Print newline after the full sequence
    }

    private void DecThenIncHelper(int A, int original) {
        if (A == 0) {
            return;
        }

        System.out.print(A + " ");
        DecThenIncHelper(A - 1, original);
        System.out.print(A + " ");
    }

    public static void main(String[] args) {
        DecNInc decNInc = new DecNInc();
        decNInc.DecThenInc(3); // Example input
    }
    
}
