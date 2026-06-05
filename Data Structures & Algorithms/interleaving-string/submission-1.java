class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if(n + m != k) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 1 ; i <= m ; i++){
            if(s2.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i] = dp[0][i - 1];
        }
        for(int j = 1 ; j <= n ; j++){
            if(s1.charAt(j - 1) == s3.charAt(j - 1)) dp[j][0] = dp[j - 1][0];
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                boolean c1 = false;
                boolean c2 = false;
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) c1 = dp[i - 1][j];
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) c2 = dp[i][j - 1];
                dp[i][j] = c1 || c2;
            }
        }
        return dp[n][m];
    }
}