class Solution {
    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int p = (int) Math.round(Math.cbrt(n));
            if ((long) p * p * p == n && isPrime(p)) {
                res += 1 + p + p * p + n;
                continue;
            }

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int j = n / i;
                    if (i != j && isPrime(i) && isPrime(j)) {
                        res += 1 + i + j + n;
                    }
                    break;
                }
            }
        }
        return res;
    }
}