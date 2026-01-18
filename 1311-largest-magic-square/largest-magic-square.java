class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Prefix sums
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1];   // main diagonal ↘
        int[][] diag2 = new int[m + 1][n + 2];   // anti diagonal ↙

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        // Try largest k first
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    if (isMagic(grid, rowSum, colSum, diag1, diag2, r, c, k)) {
                        return k;
                    }
                }
            }
        }

        return 1; // every 1x1 is magic
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum,
                            int[][] diag1, int[][] diag2,
                            int r, int c, int k) {

        int target = rowSum[r][c + k] - rowSum[r][c];

        // Check rows
        for (int i = r; i < r + k; i++) {
            if (rowSum[i][c + k] - rowSum[i][c] != target) {
                return false;
            }
        }

        // Check columns
        for (int j = c; j < c + k; j++) {
            if (colSum[r + k][j] - colSum[r][j] != target) {
                return false;
            }
        }

        // Check diagonals
        if (diag1[r + k][c + k] - diag1[r][c] != target) {
            return false;
        }

        if (diag2[r + k][c] - diag2[r][c + k] != target) {
            return false;
        }

        return true;
    }
}