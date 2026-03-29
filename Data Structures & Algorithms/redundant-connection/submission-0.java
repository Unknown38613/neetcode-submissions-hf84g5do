class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<int[]> ansList = new ArrayList<>();
        DSU dsu = new DSU(n);
        for(int[] e : edges){
            int u = e[0], v = e[1];
            boolean isCycle = dsu.union(u, v);
            if(isCycle){
                ansList.add(new int[]{u, v});
            }
        }
        return ansList.isEmpty() ? new int[]{} : ansList.get(ansList.size() - 1);
    }

    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n + 1]; //1 based
            rank = new int[n + 1];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        //path compression
        public int find(int x){
            if(parent[x] != x){
               parent[x] = find(parent[x]);
            } 
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return true;

            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if(rank[rootY] < rank[rootX]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return false;
        }
    }
}