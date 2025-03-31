/* Problem Description

Given an integer array A, sort the array using Quick Sort.

Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 109 */

public class Solution {
    public static void quickSort(int[] A, int low, int high) {
         if (low < high) {
             int pivotIndex = partition(A, low, high);
             quickSort(A, low, pivotIndex - 1);  // Sort left partition
             quickSort(A, pivotIndex + 1, high); // Sort right partition
         }
     }
 
     // Partition function to rearrange elements around the pivot
     public static int partition(int[] A, int low, int high) {
         int pivot = A[high]; // Choosing last element as pivot
         int i = low - 1; // Pointer for smaller elements
 
         for (int j = low; j < high; j++) {
             if (A[j] < pivot) {
                 i++;
                 swap(A, i, j); // Swap elements
             }
         }
 
         swap(A, i + 1, high); // Place pivot in correct position
         return i + 1; // Return pivot index
     }
 
     // Swap function
     public static void swap(int[] A, int i, int j) {
         int temp = A[i];
         A[i] = A[j];
         A[j] = temp;
     }
 
     // Function to sort an array using Quick Sort
     public static int[] solve(int[] A) {
         quickSort(A, 0, A.length - 1);
         return A; // Return the sorted array
     }
 }
 