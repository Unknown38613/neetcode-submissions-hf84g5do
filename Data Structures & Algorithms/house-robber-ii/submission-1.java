class Solution {
    private int robber(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return nums[0] >= nums[1] ? nums[0] : nums[1];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0] >= nums[1] ? nums[0] : nums[1];
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int robI = robber(Arrays.copyOfRange(nums, 0, n - 1));
        int robII = robber(Arrays.copyOfRange(nums, 1, n));
        return Math.max(robI, robII);
    }
}