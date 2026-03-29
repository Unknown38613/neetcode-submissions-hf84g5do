class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private int n = 0;

    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return ans;
        this.n = n;
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, board, column, diag1, diag2);

        return ans;
    }

    private void backtrack(int row, char[][] board, boolean[] column, boolean[] diag1, boolean[] diag2){
        if(row == n){
           List<String> listRow = new ArrayList<>();
           for(char[] r : board){
              listRow.add(new String(r));
           }
           ans.add(listRow);
           return;
        }
        for(int col = 0 ; col < n ; col++){
            int d1 = row - col + (n - 1);
            int d2 = row + col;
            if(column[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            column[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, board, column, diag1, diag2);

            board[row][col] = '.';
            column[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}