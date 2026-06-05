class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxlen = 1;
        List<int[]> coords = new ArrayList<>();
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                coords.add(new int[]{i, j});
                dp[i][j] = 1;
            }
        }

        coords.sort((a, b) -> matrix[b[0]][b[1]] - matrix[a[0]][a[1]]);

        for(int[] c : coords){
            int i = c[0];
            int j = c[1];
            for(int[] d : dir){
                int newrow = i + d[0];
                int newcol = j + d[1];
                if(newrow >= 0 && newcol >= 0 && newrow < row && newcol < col && matrix[newrow][newcol] > matrix[i][j]){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[newrow][newcol]);
                }
            }
            maxlen = Math.max(maxlen, dp[i][j]);
        }
        return maxlen;
    }
}