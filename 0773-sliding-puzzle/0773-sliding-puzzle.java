import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        // Convert the board to a string
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        String start = sb.toString();
        String target = "123450"; // Target configuration

        // Define valid moves for each position on the board
        int[][] moves = {
            {1, 3},       // 0
            {0, 2, 4},    // 1
            {1, 5},       // 2
            {0, 4},       // 3
            {1, 3, 5},    // 4
            {2, 4}        // 5
        };

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0; // Track the number of moves

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps; // Found the solution
                }

                // Find the position of '0'
                int zeroIndex = current.indexOf('0');
                
                // Generate new states by swapping '0' with its neighbors
                for (int move : moves[zeroIndex]) {
                    char[] chars = current.toCharArray();
                    // Swap '0' with the adjacent number
                    chars[zeroIndex] = chars[move];
                    chars[move] = '0';
                    String next = new String(chars);

                    // Add the new state to the queue if not visited
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }
        return -1; // No solution
    }
}
