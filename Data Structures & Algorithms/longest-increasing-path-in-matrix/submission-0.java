class Solution {
    private int[][] matrix;
    private int row, col;
    private Integer[][] memo;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int LIP(int i, int j){
        if(memo[i][j] != null) return memo[i][j];
        int maxpath = 0;
        for(int[] d : dir){
            int currrow = i + d[0];
            int currcol = j + d[1];
            if(currrow >= 0 && currcol >= 0 && currrow < row && currcol < col && matrix[currrow][currcol] > matrix[i][j]){
               maxpath = Math.max(maxpath, LIP(currrow, currcol));
            }
        }
        return memo[i][j] = 1 + maxpath;
    }
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.memo = new Integer[row][col];
        int maxlen = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                int len = LIP(i, j);
                if(len > maxlen) maxlen = len;
            }
        }
        return maxlen;
    }
}