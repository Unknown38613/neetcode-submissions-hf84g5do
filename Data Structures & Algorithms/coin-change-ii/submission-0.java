class Solution {
    private int[] coins;
    private Integer[][] memo;
    private int recurse(int i, int amount){
        if(amount == 0) return 1;
        if(amount < 0 || i >= coins.length) return 0;
        if(memo[i][amount] != null) return memo[i][amount];
        int pick = recurse(i, amount - coins[i]);
        int skip = recurse(i + 1, amount);
        return memo[i][amount] = pick + skip;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        this.coins = coins;
        this.memo = new Integer[n][amount + 1];
        return recurse(0, amount);
    }
}