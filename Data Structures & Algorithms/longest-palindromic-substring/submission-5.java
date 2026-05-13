class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = String.valueOf(s.charAt(0));
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
        }
        for(int i = 0 ; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                if(i <= n - 2) longest = s.substring(i, i + 2);
                else longest = s.substring(i);
            }
        }
        for(int len = 3 ; len <= n ; len++){
            for(int i = 0 ; i <= n - len ; i++){
                //len = j - i + 1
                int j = len + i - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    if(j <= n - 2) longest = s.substring(i, j + 1);
                    else longest = s.substring(i);
                }
            }
        }
        return longest;
    }
}