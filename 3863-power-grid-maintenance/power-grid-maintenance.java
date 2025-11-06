class Solution {
    private final int OFFLINE = 2;
    private int find(int[] root, int node) {
        if (root[node] != node) root[node] = find(root, root[node]);
        return root[node];
    }

    // Compute the starting indices in 'smallest' array for each connected group
    private int[] prefixStartIndices(int[] components) {
        int[] starts = new int[components.length];
        int s = 0;
        for (int i = 1; i < components.length; ++i) {
            int tmp = components[i];
            starts[i] = s; // starting index of component i in 'smallest' array
            s += tmp;      // move sum forward for next component
        }
        return starts;
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        final int n = c + 1;
        int[] root = new int[n];

        // Initialize union-find: each node is its own root
        for (int i = 1; i < n; ++i) root[i] = i;

        // Union nodes according to connections
        for (int[] con : connections) {
            int uRoot = find(root, con[0]);
            int vRoot = find(root, con[1]);
            root[uRoot] = root[vRoot]; // merge components
        }

        int[] components = new int[n]; // number of nodes in each connected group
        for (int i = 1; i < n; ++i) components[find(root, i)]++;

        // Compute starting indices for each component in 'smallest'
        int[] starts = prefixStartIndices(components);
        int[] ends = starts.clone(); // dynamic end pointer for each component

        // Flatten nodes into 'smallest' array, grouped by component
        int[] smallest = new int[n];
        for (int i = 1; i < n; ++i) {
            int r = root[i];         // root of current node
            int s = ends[r]++;       // next available slot in 'smallest' for this component
            smallest[s] = i;         // store node id
        }

        int[] res = new int[queries.length];
        boolean[] offline = new boolean[n]; // track offline nodes
        int len = 0; // actual length of results

        for (int[] q : queries) {
            final int mode = q[0], node = q[1];

            if (mode == OFFLINE) {
                offline[node] = true; // mark node offline
                continue;
            }

            // Maintenance query: if node is online, it resolves itself
            if (!offline[node]) {
                res[len++] = node;
                continue;
            }

            // Node is offline: find smallest online node in the same component
            int r = root[node];   // root of the component
            int s = starts[r], e = ends[r];
            while (s < e && offline[smallest[s]]) ++s; // skip offline nodes
            starts[r] = s;               // update dynamic pointer
            res[len++] = ((s == e) ? -1 : smallest[s]);
        }

        return Arrays.copyOf(res, len);
    }
}