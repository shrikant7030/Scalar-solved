public class SolutionRangeSumQuery {
    public long[] rangeSum(int[] A, int[][] B) {
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        long[] results = new long[B.length];
        for(int i = 0; i < B.length; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int sum = 0;
            if(L == 0) {
                results[i] = prefixSum[R];
            }
            else {
                results[i] = prefixSum[R] - prefixSum[L-1];
            }
        }
        return results;
    }
}


// Given an array A of N integers. Construct prefix sum of the array in the given array itself.
//
// Example: [1, 2, 3, 4, 5]
// Output: [1, 3, 6, 10, 15]
//
    public int[] prefixSum(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        return A;
    }