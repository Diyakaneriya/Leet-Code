class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;    // Number of rows
        int n = box[0].length; // Number of columns
        
        // Step 1: Apply gravity for each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // Start from the rightmost position
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; // Obstacle encountered, reset empty position
                } else if (box[i][j] == '#') {
                    // Move the stone down
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }
        
        // Step 2: Rotate the matrix 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotatedBox;
    }
}
