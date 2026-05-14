class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
            count++;
        }
        for(int i = 0 ; i < n - 1 ; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                count++;
            }
        }
        for(int len = 3 ; len <= n ; len++){
            for(int i = 0 ; i <= n - len ; i++){
                //len = j - i + 1
                int j = len + i - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                    count++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }
}