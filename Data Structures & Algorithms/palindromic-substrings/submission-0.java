class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 1) return 1;
        boolean[][] dp = new boolean[n][n];
        char[] carr = s.toCharArray();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
            count++;
        }
        for(int i = 0 ; i + 1 < n ; i++){
            if(carr[i] == carr[i + 1]){
                dp[i][i + 1] = true;
                count++;
            }
        }
        for(int len = 3 ; len <= n ; len++){
            for(int l = 0 ; len + l - 1 < n ; l++){
                int r = len + l - 1;
                if(carr[l] == carr[r] && dp[l + 1][r - 1]){
                    dp[l][r] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
