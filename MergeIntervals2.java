/*
 * Problem Description
You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 105
 */

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals2 {
    public int[][] insert(int[][] A, int[] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = A.length;
        int newStart = B[0], newEnd = B[1];

        // Step 1: Add all non-overlapping intervals before B
        while (i < n && A[i][1] < newStart) {
            result.add(A[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && A[i][0] <= newEnd) {
            newStart = Math.min(newStart, A[i][0]);
            newEnd = Math.max(newEnd, A[i][1]);
            i++;
        }
        result.add(new int[]{newStart, newEnd});

        // Step 3: Add all non-overlapping intervals after B
        while (i < n) {
            result.add(A[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals2 mergeIntervals = new MergeIntervals2();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = mergeIntervals.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
    // Output: [[1, 5], [6, 9]]
}
