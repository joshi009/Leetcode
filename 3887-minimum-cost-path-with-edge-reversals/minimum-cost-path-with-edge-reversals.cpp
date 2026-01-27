#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minCost(int n, vector<vector<int>>& edges) {
        vector<vector<pair<int,int>>> g(n);

        for (auto &e : edges) {
            int x = e[0], y = e[1], w = e[2];
            g[x].push_back({y, w});
            g[y].push_back({x, 2 * w});
        }

        vector<int> dist(n, INT_MAX);
        dist[0] = 0;

        priority_queue<pair<int,int>,
            vector<pair<int,int>>,
            greater<pair<int,int>>> pq;

        pq.push({0, 0}); // {distance, node}

        while (!pq.empty()) {
            auto [d, x] = pq.top();
            pq.pop();

            if (d > dist[x]) continue;

            if (x == n - 1) return d;

            for (auto &[y, w] : g[x]) {
                if (d + w < dist[y]) {
                    dist[y] = d + w;
                    pq.push({dist[y], y});
                }
            }
        }

        return -1;
    }
};
