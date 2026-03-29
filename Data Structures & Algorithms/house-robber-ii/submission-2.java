class Solution {
    private int robber(int[] nums, int l, int r){
        int n = r - l + 1;
        int[] dp = new int[n];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i + l], dp[i - 1]);
        }
        return dp[n - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return nums[0] >= nums[1] ? nums[0] : nums[1];
        int robI = robber(nums, 0, n - 2);
        int robII = robber(nums, 1, n - 1);
        return Math.max(robI, robII);
    }
}