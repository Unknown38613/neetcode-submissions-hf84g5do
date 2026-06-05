class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if(n + m != k) return false;
        // Space Optimized Tabulation: O(M) space instead of O(N * M)
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                boolean fromS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean fromS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                dp[j] = fromS1 || fromS2;
            }
        }
        return dp[m];
    }
}
