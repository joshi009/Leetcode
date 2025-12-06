class Solution {
    public int countPartitions(int[] nums, int k) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        long[] dp = new long[n+1];
        long[] pref = new long[n+1];
        dp[0] = pref[0] = 1;

        java.util.Deque<Integer> minD = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> maxD = new java.util.ArrayDeque<>();

        int L = 0;

        for (int i = 0; i < n; i++) {
            while (!minD.isEmpty() && nums[minD.peekLast()] > nums[i]) minD.pollLast();
            minD.addLast(i);
            while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i]) maxD.pollLast();
            maxD.addLast(i);

            while (L <= i && nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (minD.peekFirst() == L) minD.pollFirst();
                if (maxD.peekFirst() == L) maxD.pollFirst();
                L++;
            }

            dp[i+1] = pref[i] - (L > 0 ? pref[L-1] : 0);
            dp[i+1] = (dp[i+1] % MOD + MOD) % MOD;
            pref[i+1] = (pref[i] + dp[i+1]) % MOD;
        }

        return (int) dp[n];
    }
}