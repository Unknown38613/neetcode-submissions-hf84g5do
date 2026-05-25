class Solution {
    private Integer[][] memo;
    private int m, n;
    private int countpath(int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(memo[i][j] != null) return memo[i][j];
        int down = countpath(i + 1, j);
        int right = countpath(i, j + 1);
        return memo[i][j] = down + right;
    }
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new Integer[m + 1][n + 1];
        return countpath(0, 0);
    }
}