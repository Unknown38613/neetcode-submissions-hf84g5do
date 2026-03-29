class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0, maxfreq = 0, maxlen = 0;
        while(right < s.length()){
            int r = s.charAt(right) - 'A';
            freq[r]++;
            maxfreq = Math.max(maxfreq, freq[r]);
            while((right - left + 1) - maxfreq > k){
                int l = s.charAt(left) - 'A';
                freq[l]--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}
