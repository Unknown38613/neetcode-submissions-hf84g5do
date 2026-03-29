class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0, right = 0, totalcount = 0, maxlen = 0;
        while(right < s.length()){
            char curr = s.charAt(right);
            freq[curr]++;
            totalcount = Math.max(totalcount, freq[curr]);
            while(totalcount >= 2){
                char remove = s.charAt(left);
                freq[remove]--;
                if(remove == curr) totalcount--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}