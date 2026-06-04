class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalsum = 0;
        for(int i = 0 ; i < n ; i++) totalsum += nums[i];
        if(totalsum < target) return 0;
        int[][] dp = new int[n + 1][2 * totalsum + 1];
        dp[0][totalsum] = 1; 
        for(int i = 1 ; i <= n ; i++){
            for(int j = -totalsum ; j <= totalsum ; j++){
                if(dp[i - 1][j + totalsum] == 0) continue;
                dp[i][j + totalsum + nums[i - 1]] += dp[i - 1][j + totalsum];
                dp[i][j + totalsum - nums[i - 1]] += dp[i - 1][j + totalsum];
            }
        }
        return dp[n][totalsum + target];
    }
}