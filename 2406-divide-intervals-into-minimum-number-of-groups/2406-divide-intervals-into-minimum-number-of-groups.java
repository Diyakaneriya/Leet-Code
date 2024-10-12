import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});   // Start of interval
            events.add(new int[]{interval[1] + 1, -1}); // End of interval (+1)
        }

        // Sort events: if two events have the same time, sort by type (start before end)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // Sort by time
            } else {
                return a[1] - b[1];  // Sort start before end for same time
            }
        });

        int maxGroups = 0;
        int currentGroups = 0;

        // Sweep through the events
        for (int[] event : events) {
            currentGroups += event[1]; // Add 1 for start, subtract 1 for end
            maxGroups = Math.max(maxGroups, currentGroups);
        }

        return maxGroups;
    }
}
