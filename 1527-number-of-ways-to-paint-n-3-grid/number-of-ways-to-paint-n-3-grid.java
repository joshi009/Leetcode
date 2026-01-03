class Solution {
    private static final long MOD = (long)1e9 + 7L;

    public int numOfWays(int n) {
        return (int)(numOfWays(6L, 6L, n - 1) % MOD);
    }

    private long numOfWays(long threes, long twos, int n) {  // threes refer to 012 pattern, twos refer to 010 pattern 
        if (n <= 0)
            return threes + twos;
        return numOfWays((2L * threes + 2L * twos) % MOD, (2L * threes + 3L * twos) % MOD, n - 1) % MOD;
    }
}