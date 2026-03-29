class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0'; //2
            int two = (s.charAt(i - 2) - '0') * 10 + one; //12

            if (one >= 1 && one <= 9) dp[i] += dp[i - 1]; //dp[2] = 1
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2]; //dp[2] = 2
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}