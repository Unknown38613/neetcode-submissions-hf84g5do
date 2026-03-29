class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 0){
                   queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];

            for(int[] d : dir){
                int ni = d[0] + i;
                int nj = d[1] + j;
                if(ni < 0 || nj < 0 || ni >= row || nj >= col) continue;
                if(grid[ni][nj] == 2147483647){
                    grid[ni][nj] = grid[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
    }
}