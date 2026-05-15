class Solution {
    private int[] memo;
    private int decode(String s, int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != -1) return memo[i];
        int ways = decode(s, i + 1);
        if(i + 1 < s.length()){
            int twoDigits = Integer.parseInt(s.substring(i, i + 2));
            if(twoDigits >= 10 && twoDigits <= 26){
                ways += decode(s, i + 2);
            }
        }
        return memo[i] = ways;
    }
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return decode(s, 0);
    }
}