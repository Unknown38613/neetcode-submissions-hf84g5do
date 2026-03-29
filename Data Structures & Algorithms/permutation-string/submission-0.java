class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[256];
        int n = s1.length(), m = s2.length();
        for(int i = 0 ; i < n ; i++) freq[s1.charAt(i)]++;
        int left = 0, right = 0, need = n;
        while(right < m){
            char curr = s2.charAt(right);
            if(freq[curr] > 0) need--;
            freq[curr]--;
            while((right - left + 1) > n){
                char remove = s2.charAt(left);
                left++;
                if(++freq[remove] > 0) need++;
            }
            if(need == 0) return true;
            right++;
        }
        return false;
    }
}