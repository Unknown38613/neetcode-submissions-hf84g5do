class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        if(n == 1) return edges.length == 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int nei : adj.get(curr)){
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
        return count == n;
    }
}
