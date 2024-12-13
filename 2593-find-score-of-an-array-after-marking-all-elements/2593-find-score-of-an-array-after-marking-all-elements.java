import java.util.PriorityQueue;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n]; // To track marked elements
        long score = 0;

        // Priority Queue to find the smallest unmarked element and resolve ties by index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        // Add all elements to the priority queue along with their indices
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        // Process until the priority queue is empty
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the current element and its two adjacent elements
            marked[index] = true;
            if (index > 0) marked[index - 1] = true; // Left neighbor
            if (index < n - 1) marked[index + 1] = true; // Right neighbor
        }

        return score;
    }
}
