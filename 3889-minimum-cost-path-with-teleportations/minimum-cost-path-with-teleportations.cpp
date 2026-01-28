#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();

        if (k > 0 && grid[0][0] >= grid[m - 1][n - 1]) {
            return 0;
        }

        int mx = 0;
        for (auto &row : grid)
            for (int x : row)
                mx = max(mx, x);

        vector<int> sufMinF(mx + 2, INT_MAX);
        vector<int> minF(mx + 1);
        vector<int> f(n + 1);

        for (int t = 0; t <= k; t++) {
            fill(minF.begin(), minF.end(), INT_MAX);
            fill(f.begin(), f.end(), INT_MAX / 2);

            f[1] = -grid[0][0];

            for (auto &row : grid) {
                for (int j = 0; j < n; j++) {
                    int x = row[j];
                    f[j + 1] = min(
                        min(f[j], f[j + 1]) + x,
                        sufMinF[x]
                    );
                    minF[x] = min(minF[x], f[j + 1]);
                }
            }

            bool done = true;
            for (int i = mx; i >= 0; i--) {
                int mn = min(sufMinF[i + 1], minF[i]);
                if (mn < sufMinF[i]) {
                    sufMinF[i] = mn;
                    done = false;
                }
            }

            if (done) break;
        }

        return f[n];
    }
};
