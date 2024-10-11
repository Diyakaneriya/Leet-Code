import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // List to store all events (both arrivals and departures)
        ArrayList<int[]> events = new ArrayList<>();
        
        // Prepare events: [time, type, friendIndex]
        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], 1, i});  // 1 represents arrival
            events.add(new int[]{times[i][1], 0, i});  // 0 represents departure
        }
        
        // Sort events by time. If the time is the same, process departures (0) before arrivals (1)
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];  // prioritize departure over arrival
            }
            return a[0] - b[0];
        });

        // Min-heap for available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);  // initially all chairs are available
        }

        // Array to store which friend is sitting in which chair
        int[] chairAssignment = new int[n];

        // Process all events
        for (int[] event : events) {
            int time = event[0];
            int type = event[1];
            int friendIndex = event[2];

            if (type == 1) {
                // Friend arrives
                int chair = availableChairs.poll();  // Assign the smallest available chair
                chairAssignment[friendIndex] = chair;

                // If this is the target friend, return the chair they sat on
                if (friendIndex == targetFriend) {
                    return chair;
                }
            } else {
                // Friend departs
                availableChairs.add(chairAssignment[friendIndex]);  // Free the chair
            }
        }

        return -1;  // This line will never be reached
    }
}
