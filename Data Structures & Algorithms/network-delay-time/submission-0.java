class Solution {
    static class Edge{
        int dest, weight;
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //Build adjacency list
        List<List<Edge>> graph = new ArrayList<>(n);
        for(int i = 0 ; i < n + 1 ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new Edge(v, w));
        }

        //Dijkstra
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            if(visited[u]) continue;
            visited[u] = true;

            for(Edge e : graph.get(u)){
                int v = e.dest;
                int w = e.weight;
                if(!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int time = -1;
        for(int i = 1 ; i < n + 1 ; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, dist[i]);
        }
        return time;
    }
}
