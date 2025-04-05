/* Problem Description

You are developing a feature for Zomato that helps users find the nearest restaurants to their current location.
It uses GPS to determine the user's location and has access to a database of restaurants, 
each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. 
The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.

Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).

Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105 */

import java.util.*;

public class BClosestPointToOrigin {
    public static int[][] findClosestRestaurants(int[][] A, int B) {
        // Max Heap (Priority Queue) sorted by farthest distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]), 
                                        (p1[0] * p1[0] + p1[1] * p1[1]))
        );

        // Process all restaurants
        for (int[] point : A) {
            maxHeap.add(point);
            if (maxHeap.size() > B) {
                maxHeap.poll(); // Remove the farthest restaurant
            }
        }

        // Collect the closest B restaurants
        int[][] result = new int[B][2];
        for (int i = 0; i < B; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Test the function
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}, {1, -1}, {2, 3}, {-2, 2}};
        int B = 3;
        int[][] result = findClosestRestaurants(A, B);
        
        System.out.println("B Closest Restaurants:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}