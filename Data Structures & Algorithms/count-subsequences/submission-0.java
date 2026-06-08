class Solution {
    private String s, t;
    private Integer[][] memo;
    private int subs(int i, int j){
        if(j == t.length()) return 1;
        if(i >= s.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];
        int pick = 0;
        int skip = 0;
        if(s.charAt(i) == t.charAt(j)){
            pick = subs(i + 1, j + 1);
            skip = subs(i + 1, j);
        }
        else skip = subs(i + 1, j);
        return memo[i][j] = pick + skip;
    }
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.memo = new Integer[s.length() + 1][t.length() + 1];
        return subs(0, 0);
    }
}