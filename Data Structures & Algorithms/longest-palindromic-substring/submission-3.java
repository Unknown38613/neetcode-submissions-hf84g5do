class Solution {
    private Boolean[][] memo;
    private boolean isPalindrome(String s, int i, int j){
        if(i >= j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        if(memo[i][j] != null) return memo[i][j];
        return memo[i][j] = isPalindrome(s, i + 1, j - 1);
    }
    public String longestPalindrome(String s) {
       int n = s.length();
       if(n == 1) return s;
       memo = new Boolean[n][n];
       String longest = "";
       for(int i = 0 ; i < n ; i++){
         for(int j = i ; j < n ; j++){
            if(isPalindrome(s, i, j)){
               if(j - i + 1 > longest.length()){
                  longest = s.substring(i, j + 1);
               }
            }
         }
       }
       return longest; 
    }
}