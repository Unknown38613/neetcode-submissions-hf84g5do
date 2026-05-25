class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
           sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int halfsum = sum/2;
        
        boolean[][] dp = new boolean[n + 1][halfsum + 1];
        dp[0][0] = true;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= halfsum ; j++){
                boolean skip = dp[i - 1][j];
                boolean pick = false;
                if(j >= nums[i - 1]) pick = dp[i - 1][j - nums[i - 1]];
                dp[i][j] = skip || pick;
            }
        }
        return dp[n][halfsum];
    }
}