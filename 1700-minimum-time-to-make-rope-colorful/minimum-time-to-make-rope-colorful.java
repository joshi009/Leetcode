class Solution {
    public int minCost(String colors, int[] t) {
        char[] c = colors.toCharArray();
        int res = 0;
        int n = c.length;
        if (n == 1) {
            return 0;
        }
        int start = 0;
        int cur = 1;
        while (cur<n){
            if (c[cur] == c[start]) {
                int max = t[start];
                while (cur<n && c[cur] == c[start]) {
                    max = Math.max(max, t[cur]);
                    cur++;
                }
                boolean skipped = false;
                for (int i=start;i<cur;i++) {
                    if (t[i] != max) {
                        res += t[i];
                    } else if (skipped) {
                        res += t[i];
                    } else {
                        skipped = true;
                    }
                }
                start = cur;
                cur++;
            } else {
                cur++;
                start++;
            }
        }
        return res;
    }
}