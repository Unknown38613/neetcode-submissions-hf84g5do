class Solution {
    private int houserobber(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] robI = Arrays.copyOfRange(nums, 0, n - 1);
        int[] robII = Arrays.copyOfRange(nums, 1, n);
        int r1 = houserobber(robI);
        int r2 = houserobber(robII);
        return Math.max(r1, r2);
    }
}