class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int ans = dfs(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int dfs(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(map.containsKey(amount)) return map.get(amount);
        int best = Integer.MAX_VALUE;
        for(int c : coins){
            int change = dfs(coins, amount - c);
            if(change != Integer.MAX_VALUE){
                best = Math.min(best, change + 1);
                System.out.println(best);
            }
        }
        map.put(amount, best);
        return best;
    }
}