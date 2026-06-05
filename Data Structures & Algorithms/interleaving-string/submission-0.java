class Solution {
    private String s1, s2, s3;
    private Boolean[][] memo;
    private boolean recurse(int n, int m, int k){
        if(k == s3.length()) return true;
        if(memo[n][m] != null) return memo[n][m];
        boolean c1 = false;
        boolean c2 = false;
        if(n < s1.length() && s1.charAt(n) == s3.charAt(k)) c1 = recurse(n + 1, m, k + 1);
        if(m < s2.length() && s2.charAt(m) == s3.charAt(k)) c2 = recurse(n, m + 1, k + 1);
        return memo[n][m] = c1 || c2;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return recurse(0, 0, 0);
    }
}