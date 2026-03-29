class Solution {
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k){
        if(k == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(i + 1, j, k + 1)
                      || dfs(i, j + 1, k + 1)
                      || dfs(i - 1, j, k + 1)
                      || dfs(i, j - 1, k + 1);
        board[i][j] = temp;
        return result;
    }
}