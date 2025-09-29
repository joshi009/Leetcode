public class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // dp[i][j] will hold the minimum triangulation score from vertex i to vertex j

        // Loop over all lengths of the polygon segment (starting from 3 since we need at least 3 points for a triangle)
        for (int len = 3; len <= n; len++) {
            // Try every possible starting point i for a segment of length 'len'
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending point of the segment
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible 'k' between i and j to form a triangle (i, k, j)
                for (int k = i + 1; k < j; k++) {
                    int triangleScore = values[i] * values[k] * values[j];
                    int totalScore = triangleScore + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], totalScore);
                }
            }
        }

        // The result is the minimum score for the entire polygon (from 0 to n-1)
        return dp[0][n - 1];
    }
}