class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1000000007L;

        Map<Integer, Long> yCount = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            yCount.put(y, yCount.getOrDefault(y, 0L) + 1L);
        }

        long ans = 0, sum = 0;

        for (long count : yCount.values()) {
            if (count >= 2) {
                long pairs = count * (count - 1) / 2;
                ans = (ans + (pairs % MOD) * (sum % MOD)) % MOD;
                sum = (sum + pairs) % MOD;
            }
        }

        return (int) ans;
    }
}