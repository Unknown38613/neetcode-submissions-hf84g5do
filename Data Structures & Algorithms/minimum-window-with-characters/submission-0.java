class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m > n) return "";
        int[] need = new int[128];
        int[] have = new int[128];
        int left = 0, right = 0, minlength = Integer.MAX_VALUE, required = 0, formed = 0, start = 0;
        for(char c : t.toCharArray()){
            if(need[c] == 0) required++;
            need[c]++;
        }
        while(right < s.length()){
            char curr = s.charAt(right);
            have[curr]++;
            if(need[curr] > 0 && need[curr] == have[curr]){
                formed++;
            }
            while(required == formed){
               if((right - left + 1) < minlength){
                   start = left;
                   minlength = right - left + 1;
               }
               char remove = s.charAt(left);
               have[remove]--;
               if(need[remove] > 0 && need[remove] > have[remove]){
                   formed--;
               }
               left++;
            }
            right++;
        }
        return minlength == Integer.MAX_VALUE ? "" : s.substring(start, start + minlength);
    }
}
