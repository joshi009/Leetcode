class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count frequency of each spell power
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        // Step 2: Get sorted unique powers
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];  // dp[i] = max damage using first i+1 unique powers
        
        // Base case: first power
        dp[0] = freq.get(keys.get(0)) * keys.get(0);

        // Step 3: Process each unique power
        for (int i = 1; i < n; i++) {
            int currentPower = keys.get(i);
            long currentDamage = freq.get(currentPower) * currentPower;
            
            // Find the last compatible power (≤ currentPower - 3)
            int prevCompatible = binarySearch(keys, i - 1, currentPower - 3);
            
            // Option 1: Take current power + compatible previous maximum
            long takeOption = currentDamage;
            if (prevCompatible >= 0) {
                takeOption += dp[prevCompatible];
            }
            
            // Option 2: Skip current power
            long skipOption = dp[i - 1];
            
            // Take maximum of both options
            dp[i] = Math.max(takeOption, skipOption);
        }

        return dp[n - 1];
    }

    // Binary search to find the largest index ≤ end with value ≤ target
    private int binarySearch(List<Integer> keys, int end, int target) {
        int left = 0, right = end;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (keys.get(mid) <= target) {
                result = mid;  // Valid candidate, try to find larger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}