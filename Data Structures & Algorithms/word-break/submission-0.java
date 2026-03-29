class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] isPrefix = new boolean[n + 1];
        isPrefix[0] = true; //empty string
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(isPrefix[j] && set.contains(s.substring(j, i))){
                    isPrefix[i] = true;
                    break;
                }
            }
        }
        return isPrefix[n];
    }
}
