class Solution {
    private Boolean[][] memo;
    private boolean isPal(String s, int l, int r){
        if(l >= r) return true;
        if(memo[l][r] != null) return memo[l][r];
        return memo[l][r] = s.charAt(l) == s.charAt(r) && isPal(s, l + 1, r - 1);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int start = 0, end = 0, bestLen = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                if(isPal(s, i, j)){
                    int len = j - i + 1;
                    if(len > bestLen){
                        bestLen = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
