class Solution {
    static class Edge {
        int v, w;
        Edge(int v, int w) { this.v = v; this.w = w; }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int[] e : flights) graph.get(e[0]).add(new Edge(e[1], e[2]));

    // PQ entry: {totalCost, node, stopsUsed}
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[]{0, src, 0});

    int[] bestStops = new int[n];
    Arrays.fill(bestStops, Integer.MAX_VALUE);

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int cost = cur[0], u = cur[1], used = cur[2];

        if (u == dst) return cost;     // cheapest path found within k stops
        if (used > k) continue;        // cannot exceed k stops (k+1 edges)
        if (used > bestStops[u]) continue; // prune worse (more-stops) state for u
        bestStops[u] = used;

        for (Edge nei : graph.get(u)) {
            pq.offer(new int[]{cost + nei.w, nei.v, used + 1});
        }
    }
       return -1;
    }
}