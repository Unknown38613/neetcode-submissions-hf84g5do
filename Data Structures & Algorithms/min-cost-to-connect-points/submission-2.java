class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n <= 1) return 0;
        boolean[] inMST = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int totalCost = 0;

        for(int i = 0 ; i < n ; i++){
            int u = -1;
            int best = Integer.MAX_VALUE;
            for(int v = 0 ; v < n ; v++){
                if(!inMST[v] && minDist[v] < best){
                    best = minDist[v];
                    u = v;
                }
            }

            inMST[u] = true;
            totalCost += best;

            for(int v = 0 ; v < n ; v++){
                if(!inMST[v]){
                    int w = manhattan(points[u], points[v]);
                    if(w < minDist[v]){
                        minDist[v] = w;
                    }
                }
            }
        }

        return totalCost;
    }

    private int manhattan(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}