class Solution {
    private int[] cost;
    private Integer[] memo;
    private int climb(int n){
        if(n == 0 || n == 1) return cost[n];
        if(memo[n] != null) return memo[n];
        return memo[n] = cost[n] + Math.min(climb(n - 1), climb(n - 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        int n = cost.length;
        this.memo = new Integer[n];
        return Math.min(climb(n - 1), climb(n - 2));
    }
}