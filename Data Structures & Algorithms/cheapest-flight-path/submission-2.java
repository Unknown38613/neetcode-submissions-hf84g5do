class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for(int i = 0 ; i < k + 1 ; i++){
            int[] next = dist.clone();
            for(int[] nei : flights){
                int u = nei[0], v = nei[1], w = nei[2];
                if(dist[u] != INF && dist[u] + w < next[v]){
                    next[v] = dist[u] + w;
                }
            }
            dist = next;
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }
}