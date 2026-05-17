class Solution {
    private int[] coins;
    private Integer[][] memo;
    private int minCoin(int i, int target){
        if(target == 0) return 0;
        if(target < 0 || i >= coins.length) return (int) 1e9;
        if(memo[i][target] != null) return memo[i][target];
        int pick = 1 + minCoin(i, target - coins[i]);
        int skip = minCoin(i + 1, target);
        return memo[i][target] = Math.min(pick, skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        this.coins = coins;
        this.memo = new Integer[n][amount + 1];
        int result = minCoin(0, amount);
        return result == 1e9 ? -1 : result;
    }
}