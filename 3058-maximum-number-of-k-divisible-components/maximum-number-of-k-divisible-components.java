class Solution {
    private long compCnt = 0;

    private long dfs(int u , int p , long[] vals , long k , List<List<Integer>> adj) {
        long currSum = vals[u];
        for (int v : adj.get(u)) {
            if (v != p) {
                currSum += dfs(v , u , vals , k , adj);
            }
        }
        if (currSum % k == 0) {
            compCnt++;
            return 0;
        }
        else return currSum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        long K = (long) k;
        long[] vals = new long[n];
        for (int i = 0; i < n; i++) {
            vals[i] = values[i];
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, -1, vals, K, adj);

        return (int)compCnt;
    }
}