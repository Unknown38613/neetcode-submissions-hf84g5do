class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 0 (no stock) - sell stock from previous day (already no stock is handled by rest)
        // 1 (stock) - buy stock after cooldown, already holding stock
        // 2 (rest) - cooldown after selling yesterday, already resting
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = prices[i] + dp[i - 1][1];
            dp[i][1] = Math.max(-prices[i] + dp[i - 1][2], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}