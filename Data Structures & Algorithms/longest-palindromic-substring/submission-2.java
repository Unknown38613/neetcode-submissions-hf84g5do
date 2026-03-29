class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0, bestLen = 0;
        char[] carr = s.toCharArray();
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
        }
        for(int i = 0 ; i + 1 < n ; i++){
            if(carr[i] == carr[i + 1]){
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
                bestLen = 2;
            }
        }
        for(int len = 3 ; len <= n ; len++){
            for(int l = 0 ; len + l - 1 < n ; l++){
                int r = len + l - 1;
                if(carr[l] == carr[r] && dp[l + 1][r - 1]){
                    dp[l][r] = true;
                    int currlen = r - l + 1;
                    if(currlen > bestLen){
                        bestLen = currlen;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
