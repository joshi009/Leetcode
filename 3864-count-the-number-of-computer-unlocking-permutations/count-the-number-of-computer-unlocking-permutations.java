class Solution {
    public int countPermutations(int[] complexity) {
        long result = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i < complexity.length; i++) {
            if (complexity[0] >= complexity[i])
                return 0;
            result = (result * i) % MOD;
        }

        return (int) result;
    }
}