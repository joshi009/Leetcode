import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // minPrefix[posMod] = minimum prefix sum P[i] seen so far for prefix-index i with i % k == posMod
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 4);
        // prefix before any element: P[0] = 0 with index 0 -> 0 % k = 0
        minPrefix[0] = 0L;

        long prefix = 0L;      // this will hold P[j] for j = index+1
        long ans = Long.MIN_VALUE;

        for (int idx = 0; idx < n; idx++) {
            prefix += nums[idx];          // now prefix = P[idx+1]
            int j = idx + 1;
            int mod = j % k;             // use prefix-index modulo k

            // If we've already seen some P[i] with i % k == mod, candidate subarray sum = P[j] - minPrefix[mod]
            if (minPrefix[mod] != Long.MAX_VALUE / 4) {
                ans = Math.max(ans, prefix - minPrefix[mod]);
            }

            // Update the minimum prefix sum seen for this position-mod class
            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return ans;
    }
}