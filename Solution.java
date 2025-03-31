public class Solution {
    public int solve(int[] A) {
        int[] prefixEven = new int[A.length];
        int[] prefixOdd = new int[A.length];
        prefixEven[0] = A[0];
        prefixOdd[0] = 0;

        for (int i = 1; i < A.length; i++) {
            if (i % 2 == 0) {
                prefixEven[i] = prefixEven[i - 1] + A[i];
                prefixOdd[i] = prefixOdd[i - 1];
            } else {
                prefixOdd[i] = prefixOdd[i - 1] + A[i];
                prefixEven[i] = prefixEven[i - 1];
            }
        }

        int sumEven = prefixEven[A.length - 1];
        int sumOdd = prefixOdd[A.length - 1];

        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int newSumEven, newSumOdd;

            if (i == 0) {
                newSumEven = sumOdd;
                newSumOdd = sumEven - A[i];
            } else {
                newSumEven = prefixEven[i - 1] + (sumOdd - prefixOdd[i]);
                newSumOdd = prefixOdd[i - 1] + (sumEven - prefixEven[i]);
            }

            if (newSumEven == newSumOdd) {
                count++;
            }
        }

        return count;
    }
}



// list all range sum queries problems with Q queries


// 1. Range Sum Query - Immutable
// 2. Range Sum Query 2D - Immutable
// 3. Range Sum Query - Mutable
// 4. Range Sum Query 2D - Mutable
// 5. Count of Range Sum
// 6. Maximum Size Subarray Sum Equals k
// 7. Maximum Subarray Sum After One Operation
// 8. Maximum Subarray Sum After One Deletion
// 9. Maximum Subarray Sum After One Operation
// 10. Maximum Subarray Sum After One Deletion
// 11. Maximum Subarray Sum After One Operation
// 12. Maximum Subarray Sum After One Deletion
// 13. Maximum Subarray Sum After One Operation

// list all prefix sum problems
// 1. Prefix Sum


// sum of n natural number using recursion

// sum of n natural number using recursion
// sum of n natural number using recursion

int sum(N) {
    if (N == 0) {
        return 0;
    }
    return N + sum(N - 1);
}

//fibonacci using recursion
int fib(int N) {
    if (N == 0) {
        return 0;
    }
    if (N == 1) {
        return 1;
    }
    return fib(N - 1) + fib(N - 2);
}

// print 1 to A using recursion
void print(int A) {
    if (A == 0) {
        return;
    }
    print(A - 1);
    System.out.println(A);
}

//print N to 1 using recursion and 1 to N using recursion
void print(int N) {
    if (N == 0) {
        return;
    }
    System.out.println(N);
    print(N - 1);
    System.out.println(N);
}

// fast power using recursion
int power(int A, int B) {
    if (B == 0) {
        return 1;
    }
    int temp = power(A, B / 2);
    if (B % 2 == 0) {
        return temp * temp;
    } else {
        return temp * temp * A;
    }
}

// is magic number using recursion
public class Solution {
    public int solve(int A) {
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        return solve(A / 5) + solve(A / 5);
    }
}