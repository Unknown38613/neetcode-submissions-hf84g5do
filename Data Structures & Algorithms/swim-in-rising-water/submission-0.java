class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];
            if(visited[r][c]) continue;
            visited[r][c] = true;

            if(r == n - 1 && c == n - 1){
                return time;
            }

            int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for(int[] d : dir){
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;

                int nextTime = Math.max(time, grid[nr][nc]);
                pq.offer(new int[]{nextTime, nr, nc});
            }
        }
        return -1;
    }
}