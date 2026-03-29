class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n == 1) return 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        } 
        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < adj.size() ; i++){
            if(!visited[i]){
                components++;
                dfs(i, visited, adj);
            }
        }
        return components;
    }
    private void dfs(int v, boolean[] visited, List<List<Integer>> adj){
        visited[v] = true;
        for(int n : adj.get(v)){
            if(!visited[n]) dfs(n, visited, adj);
        }
    }
}
