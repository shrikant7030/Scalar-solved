
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Given an array A of size N, find the subarray of size B with the least average.
    // beggars problem - https://www.interviewbit.com/problems/beggars-outside-temple/
    public static int[] solve(int A, int[][] B) {
        int[] arr = new int[A];
        for (int i = 0; i < B.length; i++) {
            int startIndex = B[i][0] - 1;
            int endIndex = B[i][1] - 1;
            int val = B[i][2];
            arr[startIndex] += val;
            if((endIndex + 1) < A) {
                arr[endIndex + 1] -= val;
            }
        }

        for (int i = 1; i < A; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
    }

    public static int solveSumOfAllSubMatrices(int[][] A) {
        int N = A.length;

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (N - i) * (N - j);
                int contri = A[i][j] * topLeft * bottomRight;

                ans = ans + contri;
            }
        }

        return ans;
    }


    public class Solution {
        public int solve(int[][] A, int B) {
            int N = A.length;
            int M = A[0].length;
            
            int i = 0;
            int j = M - 1;
    
            int result = Integer.MAX_VALUE;
            while (i < N && j >= 0) {
                if (A[i][j] == B) {
                    int position = (i + 1) * 1009 + (j + 1);
                    result = Math.min(result, position);
                    j--;  
                } else if (A[i][j] > B) {
                    j--;
                } else {
                    i++;
                }
            }
    
            return (result == Integer.MAX_VALUE) ? -1 : result;
        }
    }

    public static String reverseFromB(String str) {
        int index = str.indexOf('b'); // Find index of 'b'
        if (index == -1) return str;  // Return original string if 'b' is not found
        System.out.println("Index: " + index);
        String reversedPart = new StringBuilder(str.substring(0, index + 1)).reverse().toString();
        return reversedPart + str.substring(index + 1);
    }

    // given an array A of size N with 1's and 2's, find the count of 1's and 2's in the array within the range of B, B will be Q^2 where Q is the size of the query array return the array of sizeB with the count of 1's and 2's
    // A = [1, 2, 1, 1, 2, 2, 1]
    // B = [[1, 2], [1, 3], [2, 4]]
    // Output: [[]]   




    // find the merge intervals of the given sorted array
    // A = [[1, 3], [2, 6], [8, 10], [15, 18]]
    // Output: [[1, 6], [8, 10], [15, 18]]
    public static int[][] mergeIntervals(int[][] A) {
        List<int[]> result = new ArrayList<>();
        int N = A.length;
        if (N == 0) return new int[0][0];
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        int[] currentInterval = A[0];
        result.add(currentInterval);
        for (int[] interval : A) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    

    // find the first missing natural number in an array
    // A = [1, 2, 3, 4, 5]
    // Output: 6
    public static int firstMissingNaturalNumber(int[] A) {
        int N = A.length;
        int i = 0;
        while (i < N) {
            if (A[i] > 0 && A[i] <= N && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < N; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return N + 1;
    }
    
    public static String longestPalindrome(String s) {
        int N = s.length();
        int start = 0, maxLen = 1;

        for (int i = 0; i < N; i++) {
            int low = i;
            int high = i;

            while (low >= 0 && high < N && s.charAt(low) == s.charAt(high)) {
                int currlen = high - low + 1;
                if(currlen > maxLen) {
                    start = low;
                    maxLen = currlen;
                }

                low--;
                high++;
            }

            low = i;
            high = i + 1;
            while (low >= 0 && high < N && s.charAt(low) == s.charAt(high)) {
                int currlen = high - low + 1;
                if(currlen > maxLen) {
                    start = low;
                    maxLen = currlen;
                }

                low--;
                high++;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String B = "aacabdkacaa";
        String result = longestPalindrome(B);
        System.out.println(result);
    }
}