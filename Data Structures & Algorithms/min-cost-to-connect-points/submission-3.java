public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;

        // Build all edges with Manhattan distance
        List<Edge> edges = new ArrayList<>(n * (n - 1) / 2);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, w));
            }
        }

        // Sort by weight
        edges.sort(Comparator.comparingInt(e -> e.w));

        DSU dsu = new DSU(n);
        int total = 0, used = 0;

        // Pick edges in increasing order, skip if they form a cycle
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                total += e.w;
                if (++used == n - 1) break; // MST complete
            }
        }
        return total;
    }

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else { parent[pb] = pa; rank[pa]++; }
            return true;
        }
    }
}