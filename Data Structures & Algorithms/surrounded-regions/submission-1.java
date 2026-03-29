class Solution {
    private int m;
    private int n;
    private void dfs(int row, int col, char[][] board){
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'O') return;
        board[row][col] = '#';
        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        this.m = row;
        this.n = col;
        for(int i = 0 ; i < row ; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][col - 1] == 'O') dfs(i, col - 1, board); 
        }
        for(int i = 0 ; i < col ; i++){
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[row - 1][i] == 'O') dfs(row - 1, i, board);
        }
          
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}