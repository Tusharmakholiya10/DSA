import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        // 1. Sort the 2D array using a custom comparator
        // Sort by start point ascending. If starts are equal, sort by end point descending.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending by end
            }
            return a[0] - b[0]; // Ascending by start
        });

        int remaining_count = 0;
        int max_end = 0;

        // 2. Loop through the 2D array elements
        for (int j = 0; j < n; j++) {
            int current_end = intervals[j][1]; // Access the 'end' element of the 2D array

            // If the current interval extends further than the maximum end seen so far,
            // it means it is NOT covered by any previous interval.
            if (current_end > max_end) {
                remaining_count++;
                max_end = current_end; // Update the boundary
            }
        }   

        return remaining_count;
    }
}