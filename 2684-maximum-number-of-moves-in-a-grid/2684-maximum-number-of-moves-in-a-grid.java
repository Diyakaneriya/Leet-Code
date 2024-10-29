class Solution {
    private int[][] dp; // DP array to store maximum moves for each cell
    private int[][] grid;
    private int m, n;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m][n];

        // Initialize DP with -1 to indicate unvisited cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int maxMoves = 0;
        // Start DFS from each cell in the first column
        for (int row = 0; row < m; row++) {
            maxMoves = Math.max(maxMoves, dfs(row, 0));
        }

        return maxMoves;
    }

    private int dfs(int row, int col) {
        // If we're out of bounds or in the last column, we can't move further
        if (col == n - 1) return 0;

        // Return the precomputed result if available
        if (dp[row][col] != -1) return dp[row][col];

        int maxMoves = 0;

        // Define the possible moves: (row - 1, col + 1), (row, col + 1), (row + 1, col + 1)
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check if new cell is within bounds and has a strictly greater value
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(newRow, newCol));
            }
        }

        // Store the result in the DP array and return it
        dp[row][col] = maxMoves;
        return maxMoves;
    }
}
