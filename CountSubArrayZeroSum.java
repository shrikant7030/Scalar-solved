/*
 * Problem Description
    Given an array A of N integers.
    Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7

    Problem Constraints
    1 <= N <= 105
    -109 <= A[i] <= 109
 * 
 */

public class CountSubArrayZeroSum {
    public int solve(int[] A) {
        int n = A.length;
        int mod = 1000000007;
        long count = 0;
        long sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // Initialize with sum 0 having one occurrence

        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
                count %= mod;
            }
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        return (int) count;

    }
}
