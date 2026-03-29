class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j, 0});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0; //if no fresh available then time remains 0
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int elapsedTime = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1], time = pos[2];
            elapsedTime = Math.max(elapsedTime, time);
            for(int[] d : dir){
                int ni = d[0] + i;
                int nj = d[1] + j;
                if(ni < 0 || nj < 0 || ni >= row || nj >= col) continue;
                if(grid[ni][nj] == 1){
                    grid[ni][nj] = 2;
                    fresh--;
                    queue.offer(new int[]{ni, nj, time + 1});
                }
            }
        }
        //no fresh should remain else -1
        return fresh == 0 ? elapsedTime : -1;
    }
}