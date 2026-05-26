class Solution {
    private String text1, text2;
    private Integer[][] memo;
    private int LCS(int i, int j){
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return memo[i][j] = 1 + LCS(i + 1, j + 1);
        return memo[i][j] = Math.max(LCS(i + 1, j), LCS(i, j + 1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.memo = new Integer[text1.length()][text2.length()];
        int res = LCS(0, 0);
        return res;
    }
}