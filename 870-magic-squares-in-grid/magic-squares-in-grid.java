class Solution {
    private boolean isMagic(int[][] grid, int r, int c) {
        // Step 1: Check Uniqueness and Range (1-9)
        int[] seen = new int[10];
        
        for (int i = r; i < r + 3; ++i) {
            for (int j = c; j < c + 3; ++j) {
                int val = grid[i][j];
                // If number is out of range 1-9 OR we have seen it before
                if (val < 1 || val > 9 || seen[val] == 1) return false;
                seen[val] = 1;
            }
        }

        // Step 2: Check Sums (Target is always 15)
        // Skip Row 2 and Col 2 as they are guaranteed if others are 15 & unique.
        
        // Row 1
        if (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] != 15) return false;
        // Row 3
        if (grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] != 15) return false;

        // Col 1
        if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] != 15) return false;
        // Col 3
        if (grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] != 15) return false;

        // Diagonal 1
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != 15) return false;
        // Diagonal 2
        if (grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2] != 15) return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m < 3 || n < 3) return 0;

        int count = 0;
        // Iterate over all possible top-left corners
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                // Optimization: Center must be 5
                if (grid[i + 1][j + 1] != 5) continue;

                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}