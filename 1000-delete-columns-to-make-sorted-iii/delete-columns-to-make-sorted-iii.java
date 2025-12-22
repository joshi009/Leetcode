import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        // dp[i] is the length of the longest valid kept subsequence of columns ending at i
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        
        int maxKeep = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                // Check if column j can precede column i for ALL strings
                if (canPrecede(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[i]);
        }
        
        // Minimum deletions = total columns - maximum columns kept
        return m - maxKeep;
    }
    
    private boolean canPrecede(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}