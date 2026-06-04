class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalsum = 0;
        for(int i = 0 ; i < n ; i++) totalsum += nums[i];
        if(Math.abs(target) > totalsum) return 0;
        int[][] dp = new int[n + 1][2 * totalsum + 1];
        dp[0][totalsum] = 1; 
        for(int i = 1 ; i <= n ; i++){
            for(int j = -totalsum ; j <= totalsum ; j++){
                int add = 0;
                if(j + totalsum - nums[i - 1] >= 0) add = dp[i - 1][j + totalsum - nums[i - 1]]; 
                int sub = 0;
                if(j + totalsum + nums[i - 1] < 2 * totalsum + 1) sub = dp[i - 1][j + totalsum + nums[i - 1]];
                dp[i][j + totalsum] = add + sub;
            }
        }
        return dp[n][totalsum + target];
    }
}