class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        char[] sarr = s.toCharArray();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] == true) {
                    String curr = s.substring(j, i + 1);
                    if (dict.contains(curr))
                        dp[i + 1] = true;
                }
            }
        }
        return dp[n];
    }
}