class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark walls and guard positions as -1
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = -1;
        }
        
        // Directions for cardinal moves (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Mark guarded cells
        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int x = guard[0];
                int y = guard[1];
                
                while (true) {
                    x += dir[0];
                    y += dir[1];
                    
                    // Stop if out of bounds or if hitting a wall/guard
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) {
                        break;
                    }
                    
                    // Mark cell as guarded (1) if it's not already marked
                    if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                    }
                }
            }
        }
        
        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        
        return unguardedCount;
    }
}
