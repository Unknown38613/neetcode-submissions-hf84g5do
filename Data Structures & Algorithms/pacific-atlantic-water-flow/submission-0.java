class Solution {
    private int[][] heights;
    private int m;
    private int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        int row = heights.length;
        int col = heights[0].length;
        this.m = row;
        this.n = col;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < row ; i++){
            dfs(i, 0, pacific); //left
            dfs(i, col - 1, atlantic); //right
        }
        for(int i = 0 ; i < col ; i++){
            dfs(0, i, pacific); //top
            dfs(row - 1, i, atlantic); //bottom
        }
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, boolean[][] ocean){
        ocean[row][col] = true;
        int[] delta_row = {-1, 0, 1, 0};
        int[] delta_col = {0, 1, 0, -1};
        for(int i = 0 ; i < 4 ; i++){
            int newrow = delta_row[i] + row;
            int newcol = delta_col[i] + col;
           
            if(newrow < 0 || 
               newcol < 0 ||
               newrow >= m || 
               newcol >= n ||
               ocean[newrow][newcol] == true ||
               heights[newrow][newcol] < heights[row][col]) continue;

            dfs(newrow, newcol, ocean);
        }
    }
}