class Solution {
    private int[] memo;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }
    private int dfs(String s, int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != -1) return memo[i];
        int ways = dfs(s, i + 1);
        if(i + 1 < s.length()){
            int two = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if(two >= 10 && two <= 26) ways += dfs(s, i + 2);
        }
        return memo[i] = ways;
    }
}
