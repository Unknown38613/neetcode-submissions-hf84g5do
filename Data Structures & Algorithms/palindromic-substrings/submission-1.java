class Solution {
    private Boolean[][] memo;
    private boolean isPalindrome(String s, int i, int j){
        if(i >= j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        if(memo[i][j] != null) return memo[i][j];
        return memo[i][j] = isPalindrome(s, i + 1, j - 1);
    }
    public int countSubstrings(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
           for(int j = i ; j < n ; j++){
               if(isPalindrome(s, i, j)) count++;
           }
        }
        return count;
    }
}